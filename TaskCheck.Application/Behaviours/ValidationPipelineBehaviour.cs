using FluentValidation;
using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Behaviours;
internal sealed class ValidationPipelineBehaviour<TRequest, TResponse>:
    IPipelineBehavior<TRequest, TResponse> 
    where TRequest : IRequest<TResponse>
    where TResponse : Result
{
    private readonly IEnumerable<IValidator<TRequest>> _validators;

    public ValidationPipelineBehaviour(IEnumerable<IValidator<TRequest>> validators)
    {
        _validators = validators;
    }

    public async Task<TResponse> Handle(TRequest request, RequestHandlerDelegate<TResponse> next, CancellationToken cancellationToken)
    {
        if (!_validators.Any())
        {
            return await next();
        }

        Error[] errors = GetAllErrors(request);

        if (errors.Length > 0)
        {
            return GenerateValidationResult<TResponse>(errors);
        }

        return await next();
    }

    private static TResult GenerateValidationResult<TResult>(Error[] errors)
        where TResult : Result
    {
        if(typeof(TResult) == typeof(Result))
        {
            return (ValidationResult.WithErrors(errors) as TResult)!;
        }

        object validationResult = typeof(ValidationResult<>)
            .GetGenericTypeDefinition()
            .MakeGenericType(typeof(TResult).GetGenericArguments().First())
            .GetMethod(nameof(ValidationResult.WithErrors))!
            .Invoke(null, [errors])!;

        return (TResult)validationResult;
    }

    private Error[] GetAllErrors(TRequest request)
    {
        return _validators.Select(v => v.Validate(request))
            .SelectMany(result => result.Errors)
            .Where(failure => failure is not null)
            .Select(failure => Error.Validation(failure.PropertyName, failure.ErrorMessage))
            .Distinct()
            .ToArray();
    }
}

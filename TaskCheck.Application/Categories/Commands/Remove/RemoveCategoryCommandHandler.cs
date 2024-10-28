using MediatR;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Remove;
internal sealed class RemoveCategoryCommandHandler: IRequestHandler<RemoveCategoryCommand, Result>
{
    private readonly ICategoryRepository _categoryRepository;

    public RemoveCategoryCommandHandler(ICategoryRepository categoryRepository)
    {
        _categoryRepository = categoryRepository;
    }

    public async Task<Result> Handle(RemoveCategoryCommand request, CancellationToken cancellationToken)
    {
        var category = await _categoryRepository.GetByIdAsync(request.Id);
        if (category is null)
        {
            return Result.Failure(CategoryErrors.NotFound);
        }

        await _categoryRepository.RemoveAsync(category, cancellationToken);

        return Result.Success();
    }
}

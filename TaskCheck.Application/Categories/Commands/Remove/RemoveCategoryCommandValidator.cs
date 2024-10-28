using FluentValidation;

namespace TaskCheck.Application.Categories.Commands.Remove;
internal sealed class RemoveCategoryCommandValidator: AbstractValidator<RemoveCategoryCommand>
{
    public RemoveCategoryCommandValidator()
    {
        RuleFor(x => x.Id).NotEmpty();
    }
}



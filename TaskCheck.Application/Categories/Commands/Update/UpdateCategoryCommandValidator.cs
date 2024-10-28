using FluentValidation;

namespace TaskCheck.Application.Categories.Commands.Update;

internal sealed class UpdateCategoryCommandValidator: AbstractValidator<UpdateCategoryCommand>
{
    public UpdateCategoryCommandValidator()
    {
        RuleFor(v => v.Id)
            .NotEmpty();
        RuleFor(v => v.Title)
            .NotEmpty().WithMessage("Title is required.")
            .Length(5, 50).WithMessage("Title must be between 5 and 50 characters long.");
    }
}

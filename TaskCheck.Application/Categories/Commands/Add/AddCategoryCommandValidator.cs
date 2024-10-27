using FluentValidation;

namespace TaskCheck.Application.Categories.Commands.Add;
internal sealed class AddCategoryCommandValidator : AbstractValidator<AddCategoryCommand>
{
    public AddCategoryCommandValidator()
    {
        RuleFor(v => v.Id)
            .NotEmpty();
        RuleFor(v => v.Title)
            .NotEmpty().WithMessage("Title is required.")
            .Length(5, 50).WithMessage("Title must be between 5 and 50 characters long.");
    }
}



using FluentValidation;

namespace TaskCheck.Application.Tasks.Commands.Update;
internal sealed class UpdateUserTaskCommandValidator: AbstractValidator<UpdateUserTaskCommand>
{
    public UpdateUserTaskCommandValidator()
    {
        RuleFor(x => x.Title).NotEmpty()
            .WithMessage("Task title cannot be empty.")
            .Length(5, 50).WithMessage("Task title must be between 5 and 50 characters long.");

        RuleFor(x => x.Details).Length(5, 100)
            .WithMessage("Task details must be between 5 and 100 characters long");

        RuleFor(x => x.DueDate).NotEmpty()
            .WithMessage("Due date is required.");

    }
}



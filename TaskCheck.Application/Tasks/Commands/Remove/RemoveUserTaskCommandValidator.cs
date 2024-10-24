using FluentValidation;

namespace TaskCheck.Application.Tasks.Commands.Remove;
internal sealed class RemoveUserTaskCommandValidator : AbstractValidator<RemoveUserTaskCommand>
{
    public RemoveUserTaskCommandValidator()
    {
        RuleFor(v => v.Id).NotEmpty();
    }
}


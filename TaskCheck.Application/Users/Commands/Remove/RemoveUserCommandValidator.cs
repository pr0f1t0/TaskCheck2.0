﻿using FluentValidation;

namespace TaskCheck.Application.Users.Commands.Remove;
internal sealed class RemoveUserCommandValidator : AbstractValidator<RemoveUserCommand>
{
    public RemoveUserCommandValidator()
    {
        RuleFor(x => x.Id).NotEmpty();
    }
}


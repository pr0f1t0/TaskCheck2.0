using FluentValidation;

namespace TaskCheck.Application.Users.Commands.Add;

internal sealed class AddUserCommandValidator : AbstractValidator<AddUserCommand>
{
    public AddUserCommandValidator()
    {
        RuleFor(x => x.Username)
            .NotEmpty().WithMessage("Username is required.")
            .MaximumLength(50).WithMessage("Username must not exceed 50 characters.");
        
        RuleFor(x => x.FirstName)
            .NotEmpty().WithMessage("Firstname is required.")
            .MaximumLength(30).WithMessage("Firstname must not exceed 30 characters.");
        
        RuleFor(x => x.Email)
            .NotEmpty().WithMessage("Email is required.")
            .MaximumLength(50).WithMessage("Email must not exceed 50 characters.")
            .EmailAddress().WithMessage("Email is not valid.");
        
        RuleFor(x => x.Password)
            .NotEmpty().WithMessage("Password is required.")
            .MinimumLength(6).WithMessage("Password must not be less than 6 characters.");
        
        RuleFor(x => x.PasswordRepeat)
            .Equal(x => x.Password).WithMessage("Passwords do not match.");
    }
}
    

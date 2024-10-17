using MediatR;
using TaskCheck.Application.Users.DTO;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Add;

 public record AddUserCommand (
    string Username,
    string FirstName,
    string Email,
    string Password,
    string PasswordRepeat) : IRequest<Result<RegisterResponse>>;


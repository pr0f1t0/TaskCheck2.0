using MediatR;
using TaskCheck.Application.Users.DTO;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Login;

public record LoginUserCommand(
    string Username,
    string Password
) : IRequest<Result<LoginResponse>>;


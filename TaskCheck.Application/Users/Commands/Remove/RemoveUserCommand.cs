using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Remove;
public sealed record RemoveUserCommand
(
    Guid Id
) : IRequest<Result>;

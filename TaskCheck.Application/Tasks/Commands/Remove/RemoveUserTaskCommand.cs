using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Remove;
public sealed record RemoveUserTaskCommand
(
    Guid Id
) : IRequest<Result>;



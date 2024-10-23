using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Update;
public sealed record UpdateUserTaskCommand
(
    Guid Id,
    string Title,
    string Details,
    DateTime DueDate,
    DateTime CreationDate,
    bool IsCompleted,
    bool IsImportant,
    Guid? CategoryId,
    Guid UserId
): IRequest<Result>;


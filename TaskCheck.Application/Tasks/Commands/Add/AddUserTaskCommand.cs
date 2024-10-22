using MediatR;
using TaskCheck.Application.Tasks.DTO;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Add;

public sealed record AddUserTaskCommand(
    Guid Id,
    string Title,
    string Details,
    DateTime DueDate,
    DateTime CreationDate,
    bool IsCompleted,
    bool IsImportant,
    Guid? CategoryId
    ) : IRequest<Result>;


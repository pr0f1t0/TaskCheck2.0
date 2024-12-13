using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Add;

public sealed record AddCategoryCommand
(
    Guid Id,
    Guid UserId,
    string Title
) : IRequest<Result>;


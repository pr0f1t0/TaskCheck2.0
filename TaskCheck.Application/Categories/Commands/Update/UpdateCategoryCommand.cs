using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Update;

public sealed record UpdateCategoryCommand
(
    Guid Id,
    string Title
) : IRequest<Result>;

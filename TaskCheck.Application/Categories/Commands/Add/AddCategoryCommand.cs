using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Add;

public sealed record AddCategoryCommand
(
    Guid Id,
    string Title
) : IRequest<Result>;


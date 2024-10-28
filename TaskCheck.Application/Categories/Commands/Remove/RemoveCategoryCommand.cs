using MediatR;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Remove;
public sealed record RemoveCategoryCommand
(
    Guid Id   
) : IRequest<Result>;


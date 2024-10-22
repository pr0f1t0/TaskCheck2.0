using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Application.Tasks.DTO;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Add;

internal sealed class AddUserTaskCommandHandler : IRequestHandler<AddUserTaskCommand, Result>
{
    private readonly ITaskRepository _taskRepository;
    private readonly IUserRepository _userRepository;
    private readonly IUnitOfWork _unitOfWork;

    public AddUserTaskCommandHandler(ITaskRepository taskRepository, IUserRepository userRepository, IUnitOfWork unitOfWork)
    {
        _taskRepository = taskRepository;
        _userRepository = userRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result> Handle(AddUserTaskCommand request, CancellationToken cancellationToken)
    {
        var task = new UserTask()
        {
            Id = request.Id,
            Title = request.Title,
            Details = request.Details,
            DueDate = request.DueDate,
            CreationDate = request.DueDate,
            IsCompleted = request.IsCompleted,
            IsImportant = request.IsImportant,
            CategoryId = request.CategoryId
        };

        await _taskRepository.AddAsync(task, cancellationToken);

        await _unitOfWork.SaveChangesAsync(cancellationToken);

        return Result.Success();
    }
}



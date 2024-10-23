using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Update;
internal sealed class UpdateUserTaskCommandHandler : IRequestHandler<UpdateUserTaskCommand, Result>
{
    private readonly ITaskRepository _taskRepository;
    private readonly IUserRepository _userRepository;
    private readonly IUnitOfWork _unitOfWork;

    public UpdateUserTaskCommandHandler(ITaskRepository taskRepository, IUnitOfWork unitOfWork, IUserRepository userRepository)
    {
        _taskRepository = taskRepository;
        _unitOfWork = unitOfWork;
        _userRepository = userRepository;
    }

    public async Task<Result> Handle(UpdateUserTaskCommand request, CancellationToken cancellationToken)
    {
        var task = await _taskRepository.GetByIdAsync(request.Id);

        if (task is null)
        {
            return Result.Failure(TaskErrors.NotFound);
        }

        var updatedTask = new UserTask()
        {
            Id = request.Id,
            Title = request.Title,
            Details = request.Details,
            DueDate = request.DueDate,
            CreationDate = request.CreationDate,
            IsCompleted = request.IsCompleted,
            IsImportant = request.IsImportant,
            CategoryId = request.CategoryId,
            User = await _userRepository.GetByIdAsync(request.UserId, cancellationToken)
        };

        await _taskRepository.UpdateAsync(task, updatedTask, cancellationToken);

        return Result.Success();
    }
}


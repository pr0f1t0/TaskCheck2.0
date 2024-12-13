using MediatR;
using Microsoft.VisualBasic;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Update;
internal sealed class UpdateUserTaskCommandHandler : IRequestHandler<UpdateUserTaskCommand, Result>
{
    private readonly ITaskRepository _taskRepository;
    private readonly IUnitOfWork _unitOfWork;

    public UpdateUserTaskCommandHandler(ITaskRepository taskRepository, IUnitOfWork unitOfWork, IUserRepository userRepository)
    {
        _taskRepository = taskRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result> Handle(UpdateUserTaskCommand request, CancellationToken cancellationToken)
    {
        var task = await _taskRepository.GetByIdAsync(request.Id);

        if (task is null)
        {
            return Result.Failure(TaskErrors.NotFound);
        }

        task.Title = request.Title;
        task.Details = request.Details;
        task.DueDate = request.DueDate;
        task.CreationDate = request.CreationDate;
        task.IsCompleted = request.IsCompleted;
        task.IsImportant = request.IsImportant;
        task.Category = request.Category;

        await _taskRepository.UpdateAsync(task);
        await _unitOfWork.SaveChangesAsync(cancellationToken);

        return Result.Success();
    }
}


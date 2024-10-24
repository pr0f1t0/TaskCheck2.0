using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Tasks.Commands.Remove;
internal sealed class RemoveUserTaskCommandHandler : IRequestHandler<RemoveUserTaskCommand, Result>
{
    private readonly ITaskRepository _taskRepository;
    private readonly IUnitOfWork _unitOfWork;

    public RemoveUserTaskCommandHandler(ITaskRepository taskRepository, IUnitOfWork unitOfWork)
    {
        _taskRepository = taskRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result> Handle(RemoveUserTaskCommand request, CancellationToken cancellationToken)
    {
        var userTask = await _taskRepository.GetByIdAsync(request.Id);
        if (userTask == null)
        {
            return Result.Failure(TaskErrors.NotFound);
        }

        await _taskRepository.RemoveAsync(userTask);
        await _unitOfWork.SaveChangesAsync(cancellationToken);

        return Result.Success();
    }
}


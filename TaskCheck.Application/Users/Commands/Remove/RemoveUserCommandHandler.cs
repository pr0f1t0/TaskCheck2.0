using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Remove;
internal sealed class RemoveUserCommandHandler : IRequestHandler<RemoveUserCommand, Result>
{
    private readonly IUserRepository _userRepository;
    private readonly IUnitOfWork _unitOfWork;

    public RemoveUserCommandHandler(IUserRepository userRepository, IUnitOfWork unitOfWork)
    {
        _userRepository = userRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result> Handle(RemoveUserCommand request, CancellationToken cancellationToken)
    {
        var user = await _userRepository.GetByIdAsync(request.Id);
        if (user == null)
        {
            return Result.Failure(UserErrors.NotFound);
        }

        await _userRepository.RemoveAsync(user);
        await _unitOfWork.SaveChangesAsync(cancellationToken);

        return Result.Success();
    }
}

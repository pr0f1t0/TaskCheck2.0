using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Application.Abstractions.Identity;
using TaskCheck.Application.Users.DTO;
using TaskCheck.Application.Users.Identity;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Add;

internal sealed class AddUserCommandHandler : IRequestHandler<AddUserCommand, Result<RegisterResponse>>
{
    private readonly IUserRepository _userRepository;
    private readonly IIdentityService _identityService;
    private readonly ITokenService _tokenService;
    private readonly IUnitOfWork _unitOfWork;

    public AddUserCommandHandler(IUserRepository userRepository, IIdentityService identityService, ITokenService tokenService, IUnitOfWork unitOfWork)
    {
        _userRepository = userRepository;
        _identityService = identityService;
        _tokenService = tokenService;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result<RegisterResponse>> Handle(AddUserCommand request, CancellationToken cancellationToken)
    {
        var user = new User() {Username = request.Username, FirstName = request.FirstName, Email = request.Email };      
        await _userRepository.AddAsync(user, cancellationToken);

        var applicationUser = new ApplicationUser() { Id = user.Id.ToString(), Email = user.Email, UserName = user.Username };
        
        var existingUser = await _userRepository.ExistsAsync(user.Username, user.Email, cancellationToken);

        await _identityService.CreateUserAsync(applicationUser, request.Password, cancellationToken);

        await _unitOfWork.SaveChangesAsync(cancellationToken);

        var accessToken = _tokenService.GenerateToken(user);

        return Result.Success(new RegisterResponse(accessToken));
    }
}


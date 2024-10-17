using MediatR;
using TaskCheck.Application.Abstractions.Identity;
using TaskCheck.Application.Users.DTO;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Users.Commands.Login;

internal sealed class LoginUserCommandHandler: IRequestHandler<LoginUserCommand, Result<LoginResponse>>
{
    private readonly IIdentityService _identityService;
    private readonly IUserRepository _userRepository;
    private readonly ITokenService _tokenService;

    public LoginUserCommandHandler(IIdentityService identityService, IUserRepository userRepository, ITokenService tokenService)
    {
        _identityService = identityService;
        _userRepository = userRepository;
        _tokenService = tokenService;
    }

    public async Task<Result<LoginResponse>> Handle(LoginUserCommand request, CancellationToken cancellationToken)
    {
        var applicationUserId = await _identityService.GetIdentityUserId(request.Username, request.Password);

        var user = await _userRepository.GetByIdAsync(applicationUserId);

        var accessToken = _tokenService.GenerateToken(user);

        return Result.Success(new LoginResponse(accessToken));
    }
}


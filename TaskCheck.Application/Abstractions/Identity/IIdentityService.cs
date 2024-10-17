using TaskCheck.Application.Users.Identity;

namespace TaskCheck.Application.Abstractions.Identity;

public interface IIdentityService
{
    Task CreateUserAsync(ApplicationUser applicationUser, string password, CancellationToken cancellationToken);
    Task<Guid> GetIdentityUserId(string username, string password);
}


using TaskCheck.Domain.Entities;

namespace TaskCheck.Application.Abstractions.Identity
{
    public interface ITokenService
    {
        string GenerateToken(User user);

    }
}

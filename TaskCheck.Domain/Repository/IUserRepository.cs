using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository.Abstractions;

namespace TaskCheck.Domain.Repository;

public interface IUserRepository: IRepository<User>
{
    Task DeleteAsync(User user);

    Task UpdateAsync(User user);

    Task<bool> ExistsAsync(
        Guid userId,
        CancellationToken cancellationToken = default);

    Task<bool> ExistsAsync(
        string username,
        CancellationToken cancellationToken = default);

    Task<bool> ExistsAsync(
        string username,
        string email,
        CancellationToken cancellationToken = default);
}


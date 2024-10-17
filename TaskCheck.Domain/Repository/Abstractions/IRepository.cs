using TaskCheck.Domain.Entities.Abstractions;

namespace TaskCheck.Domain.Repository.Abstractions;

public interface IRepository<TEntity>
    where TEntity : BaseEntity
{
    Task AddAsync(TEntity entity, CancellationToken cancellationToken = default);

    Task UpdateAsync(TEntity oldEntity, TEntity newEntity, CancellationToken cancellationToken = default);

    Task RemoveAsync(TEntity entity, CancellationToken cancellationToken = default);

    Task<TEntity> GetByIdAsync(Guid id);

    Task<bool> ExistsAsync(Guid id);

    Task<IEnumerable<TEntity>> GetAllAsync();
}



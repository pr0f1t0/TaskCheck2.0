using Microsoft.EntityFrameworkCore;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository;

namespace TaskCheck.Infrastructure.Persistence.Repositories;
internal sealed class TaskRepository : ITaskRepository
{
    private readonly ApplicationDbContext _context;

    public TaskRepository(ApplicationDbContext context)
    {
        _context = context;
    }

    public async Task AddAsync(UserTask userTask, CancellationToken cancellationToken = default)
    {
        await _context.UserTasks.AddAsync(userTask, cancellationToken);
    }

    public async Task<bool> ExistsAsync(Guid id, CancellationToken cancellationToken = default)
    {
        return await _context.UserTasks.FindAsync(id, cancellationToken) is not null;
    }

    public async Task<IEnumerable<UserTask>> GetAllAsync()
    {
        return await _context.UserTasks.ToListAsync();
    }

    public async Task<UserTask> GetByIdAsync(Guid? id)
    {
        return await _context.UserTasks.FirstOrDefaultAsync(c => c.Id == id);
    }

    public Task RemoveAsync(UserTask userTask, CancellationToken cancellationToken = default)
    {
        _context.UserTasks.Remove(userTask);
        return Task.CompletedTask;
    }

    public Task UpdateAsync(UserTask userTask)
    {
        _context.UserTasks.Update(userTask);
        return Task.CompletedTask;
    }
}


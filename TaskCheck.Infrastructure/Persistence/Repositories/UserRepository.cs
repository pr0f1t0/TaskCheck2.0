
using Microsoft.EntityFrameworkCore;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository;

namespace TaskCheck.Infrastructure.Persistence.Repositories;
internal sealed class UserRepository : IUserRepository
{
    private readonly ApplicationDbContext _context;

    public UserRepository(ApplicationDbContext context)
    {
        _context = context;
    }

    public async Task AddAsync(User user, CancellationToken cancellationToken = default)
    {
        await _context.Users.AddAsync(user, cancellationToken);   
    }

    public Task DeleteAsync(User user)
    {
        _context.Users.Remove(user);
        return Task.CompletedTask;
    }

    public async Task<bool> ExistsAsync(Guid id, CancellationToken cancellationToken = default)
    {
        return await _context.Users.FindAsync(id, cancellationToken) is not null;
    }

    public async Task<bool> ExistsAsync(string username, CancellationToken cancellationToken = default)
    {
        return await _context.Users.FirstOrDefaultAsync(u => u.Username == username, cancellationToken) is not null;
    }

    public async Task<bool> ExistsAsync(string username, string email, CancellationToken cancellationToken = default)
    {
        return await _context.Users.FirstOrDefaultAsync(u => u.Username == username || u.Email == email, cancellationToken) is not null;
    }

    public async Task<IEnumerable<User>> GetAllAsync()
    {
        return await _context.Users.ToListAsync();
    }

    public async Task<User> GetByIdAsync(Guid? id)
    {
        return await _context.Users.FirstOrDefaultAsync(t => t.Id == id);
    }

    public Task RemoveAsync(User user, CancellationToken cancellationToken = default)
    {
        _context.Users.Remove(user);
        return Task.CompletedTask;
    }

    public Task UpdateAsync(User user)
    {
        _context.Users.Update(user);
        return Task.CompletedTask;
    }


}


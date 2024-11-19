using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using TaskCheck.Application.Users.Identity;
using TaskCheck.Domain.Entities;

namespace TaskCheck.Infrastructure.Persistence;
public sealed class ApplicationDbContext : IdentityDbContext<ApplicationUser>
{
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) : base(options)
    {}

    public DbSet<Category> Categories { get; init; }

    public DbSet<UserTask> UserTasks { get; init; }

    public DbSet<User> Users { get; init; }

    protected override void OnModelCreating(ModelBuilder builder)
    {
        base.OnModelCreating(builder);
        builder.ApplyConfigurationsFromAssembly(typeof(ApplicationDbContext).Assembly);
    }

}


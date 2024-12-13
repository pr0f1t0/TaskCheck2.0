using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using TaskCheck.Domain.Entities;

namespace TaskCheck.Infrastructure.Persistence.Configurations;
internal sealed class UserConfiguration: IEntityTypeConfiguration<User>
{
    public void Configure(EntityTypeBuilder<User> builder)
    {
        builder.HasIndex(user => user.Id)
            .IsUnique();

        builder.HasMany(user => user.Tasks)
            .WithOne(task => task.User)
            .HasForeignKey(task => task.Id)
            .OnDelete(DeleteBehavior.ClientCascade);

        builder.HasMany(user => user.Categories)
            .WithOne(category => category.User)
            .HasForeignKey(category => category.Id)
            .OnDelete(DeleteBehavior.ClientCascade);
    }
}


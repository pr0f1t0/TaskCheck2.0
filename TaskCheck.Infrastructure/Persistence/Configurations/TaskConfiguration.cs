using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using TaskCheck.Domain.Entities;

namespace TaskCheck.Infrastructure.Persistence.Configurations;
internal sealed class TaskConfiguration: IEntityTypeConfiguration<UserTask>
{
    public void Configure(EntityTypeBuilder<UserTask> builder)
    {
        builder.HasIndex(task => task.Id)
            .IsUnique();

        builder.HasOne(task => task.User)
            .WithMany(user => user.Tasks)
            .HasForeignKey(task => task.User.Id)
            .OnDelete(DeleteBehavior.ClientCascade);

        builder.HasOne(task => task.Category)
            .WithMany(category => category.UserTasks)
            .HasForeignKey(task => task.Category.Id)
            .OnDelete(DeleteBehavior.ClientCascade);
    }
}


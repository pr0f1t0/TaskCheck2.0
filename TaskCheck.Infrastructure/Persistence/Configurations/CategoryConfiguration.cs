using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using TaskCheck.Domain.Entities;


namespace TaskCheck.Infrastructure.Persistence.Configurations;
internal sealed class CategoryConfiguration: IEntityTypeConfiguration<Category>
{
    public void Configure(EntityTypeBuilder<Category> builder)
    {
        builder.HasIndex(category => category.Id)
            .IsUnique();

        builder.HasMany(category => category.UserTasks)
            .WithOne(task => task.Category)
            .HasForeignKey(task => task.Category.Id)
            .OnDelete(DeleteBehavior.ClientCascade);

        builder.HasOne(category => category.User)
            .WithMany(user => user.Categories)
            .HasForeignKey(category => category.User.Id)
            .OnDelete(DeleteBehavior.ClientCascade);
    }
}

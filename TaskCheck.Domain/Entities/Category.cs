using TaskCheck.Domain.Entities.Abstractions;

namespace TaskCheck.Domain.Entities;

public class Category: BaseEntity
{
    public string Title { get; set; }

    public User User { get; set; }

    public ICollection<UserTask>? UserTasks { get; set; }
}


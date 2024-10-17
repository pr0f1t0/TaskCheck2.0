using TaskCheck.Domain.Entities.Abstractions;

namespace TaskCheck.Domain.Entities;

public class Category: BaseEntity
{
    public string Title { get; set; }

    public IEnumerable<UserTask>? UserTasks { get; set; }
}


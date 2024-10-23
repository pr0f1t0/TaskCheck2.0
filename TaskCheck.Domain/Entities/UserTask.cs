using TaskCheck.Domain.Entities.Abstractions;

namespace TaskCheck.Domain.Entities;

public class UserTask: BaseEntity
{
    public string Title { get; set; }

    public string? Details { get; set; }

    public DateTime DueDate { get; set; }

    public DateTime CreationDate { get; set; }

    public bool IsCompleted { get; set; }

    public bool IsImportant { get; set; }

    public Guid? CategoryId { get; set; }

    public User User { get; set; }

}


using TaskCheck.Domain.Entities.Abstractions;

namespace TaskCheck.Domain.Entities;

public class User: BaseEntity
{
    public string Username { get; set; }

    public string FirstName { get; set; }

    public string Email { get; set; }

    public ICollection<UserTask>? Tasks { get; set; }

    public ICollection<Category>? Categories { get; set; }
}


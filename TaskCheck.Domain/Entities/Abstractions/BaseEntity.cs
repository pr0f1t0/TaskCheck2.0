namespace TaskCheck.Domain.Entities.Abstractions;

public abstract class BaseEntity
{
    public Guid Id { get; set; } = Guid.NewGuid();
}


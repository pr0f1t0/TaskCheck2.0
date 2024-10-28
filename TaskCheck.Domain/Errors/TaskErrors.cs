using TaskCheck.Domain.Shared;

namespace TaskCheck.Domain.Errors;

public static class TaskErrors
{
    public static readonly Error NotFound = Error.NotFound
        (
        code: "task_not_found",
        description: "Task cannot be found."
        );

}


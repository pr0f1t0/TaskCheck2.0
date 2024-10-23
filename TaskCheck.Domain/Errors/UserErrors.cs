using TaskCheck.Domain.Shared;

namespace TaskCheck.Domain.Errors;
public static class UserErrors
{
    public static readonly Error NotFound = Error.NotFound
        (
        code: "user_not_found", 
        description: "User not found."
        );

    public static readonly Error Exists = Error.Validation
        (
        code: "user_exists",
        description: "This user is already registered"
        );

}


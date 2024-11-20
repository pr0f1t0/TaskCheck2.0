using TaskCheck.Domain.Shared;

namespace TaskCheck.Domain.Errors;
public static class UserErrors
{
    public static readonly Error NotFound = Error.NotFound
        (
        code: "user_not_found", 
        description: "User cannot be found."
        );

    public static readonly Error Exists = Error.Validation
        (
        code: "user_exists",
        description: "This user is already registered"
        );

    public static readonly Error InvalidAccessToken = Error.Validation
       (
       code: "User.InvalidAccessToken",
       description: "Access token is invalid."
       );

    public static readonly Error InvalidCredentials = Error.Validation
        (
        code: "User.InvalidCredentials",
        description: "Credentials are invalid"
        );
}


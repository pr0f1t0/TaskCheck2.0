using TaskCheck.Domain.Shared;

namespace TaskCheck.Domain.Errors;
public static class CategoryErrors
{
    public static readonly Error NotFound = Error.NotFound
    (
    code: "category_not_found",
    description: "Category cannot be found."
    );
}


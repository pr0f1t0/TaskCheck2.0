using Microsoft.Extensions.DependencyInjection;

namespace TaskCheck.Application;

public static class DependencyInjection
{
    public static IServiceCollection AddApplication(this IServiceCollection services)
    {
        return services;
    }
}


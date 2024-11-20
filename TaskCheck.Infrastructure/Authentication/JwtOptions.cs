using Microsoft.IdentityModel.Tokens;
using System.ComponentModel.DataAnnotations;

namespace TraffiLearn.Infrastructure.Authentication.Options;
public sealed class JwtSettings
{
    public const string SectionName = nameof(JwtSettings);

    [Required]
    [StringLength(200)]
    public string? Issuer { get; set; }

    [Required]
    [StringLength(200)]
    public string? Audience { get; set; }

    [Required]
    public string? SecretKey { get; set; }

    [Range(1, 10)]
    public int ExpirationTimeInDays { get; set; } = 3;

    public string SecurityAlgorithm = SecurityAlgorithms.HmacSha256;
}

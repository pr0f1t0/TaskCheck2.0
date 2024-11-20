using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;
using System.Text;
using TaskCheck.Application.Abstractions.Identity;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Shared;
using TraffiLearn.Infrastructure.Authentication.Options;

namespace TaskCheck.Infrastructure.Services;

internal sealed class JwtTokenService : ITokenService
{
    private readonly SymmetricSecurityKey _symmetricSecurityKey;
    private readonly JwtSettings _jwtSettings;

    public JwtTokenService(SymmetricSecurityKey symmetricSecurityKey, JwtSettings jwtSettings)
    {
        _symmetricSecurityKey = symmetricSecurityKey;
        _jwtSettings = jwtSettings;
    }

    public string GenerateToken(User user)
    {
        var claims = GenerateClaims(user);

        var SigningCredentials = new SigningCredentials(_symmetricSecurityKey, _jwtSettings.SecurityAlgorithm);
        var token = GenerateJwtToken(claims, SigningCredentials);

        return GenerateTokenString(token);
    }

    public async Task<Result> ValidateAccessTokenAsync(string accessToken, bool validateLifeTime = true)
    {
        var tokenHandler = new JwtSecurityTokenHandler();
        var validationParameters = GetTokenValidationParameters(validateLifeTime);

        var validationResult = await tokenHandler.ValidateTokenAsync(accessToken, validationParameters);

        if(!validationResult.IsValid)
        {
            return Result.Failure(UserErrors.InvalidAccessToken);
        }

        return Result.Success();
    }




    #region Private Methods

    private Claim[] GenerateClaims(User user)
    {
        return
        [
            new(JwtRegisteredClaimNames.Sub, user.Id.ToString()),
                new(JwtRegisteredClaimNames.Email, user.Email.ToString()),
        ];
    }

    private JwtSecurityToken GenerateJwtToken(Claim[] claims, SigningCredentials signingCredentials)
    {
        return new JwtSecurityToken(
            issuer: _jwtSettings.Issuer,
            audience: _jwtSettings.Audience,
            claims: claims,
            expires: DateTime.UtcNow.AddDays(_jwtSettings.ExpirationTimeInDays),
            signingCredentials: signingCredentials
        );
    }

    private string GenerateTokenString(JwtSecurityToken jwtSecurityToken)
    {
        var tokenHandler = new JwtSecurityTokenHandler();
        return tokenHandler.WriteToken(jwtSecurityToken);
    }

    private TokenValidationParameters GetTokenValidationParameters(
    bool validateLifeTime = true)
    {
        return new()
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = validateLifeTime,
            ValidateIssuerSigningKey = true,
            ValidIssuer = _jwtSettings.Issuer,
            ValidAudience = _jwtSettings.Audience,
            IssuerSigningKey = _symmetricSecurityKey
        };
    }
    #endregion
}
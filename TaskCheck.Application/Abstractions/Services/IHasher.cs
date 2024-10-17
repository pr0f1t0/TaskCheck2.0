namespace TaskCheck.Application.Abstractions.Services;

public interface IHasher
{
    string Hash(string value);
}


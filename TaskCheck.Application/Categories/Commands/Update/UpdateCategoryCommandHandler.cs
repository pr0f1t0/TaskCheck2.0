using MediatR;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Errors;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Update;
internal sealed class UpdateCategoryCommandHandler: IRequestHandler<UpdateCategoryCommand, Result>
{
    private readonly ICategoryRepository _categoryRepository;

    public UpdateCategoryCommandHandler(ICategoryRepository categoryRepository)
    {
        _categoryRepository = categoryRepository;
    }

    public async Task<Result> Handle(UpdateCategoryCommand request, CancellationToken cancellationToken)
    {
        var category = await _categoryRepository.GetByIdAsync(request.Id);
        if (category is null)
        {
            return Result.Failure(CategoryErrors.NotFound);
        }

        var newCategory = new Category() 
        {
            Id = request.Id,
            Title = request.Title
        };

        await _categoryRepository.UpdateAsync(category, newCategory, cancellationToken);

        return Result.Success();
    }
}


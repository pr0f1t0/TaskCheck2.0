﻿using MediatR;
using TaskCheck.Application.Abstractions.Data;
using TaskCheck.Domain.Entities;
using TaskCheck.Domain.Repository;
using TaskCheck.Domain.Shared;

namespace TaskCheck.Application.Categories.Commands.Add;
internal sealed class AddCategoryCommandHandler : IRequestHandler<AddCategoryCommand, Result>
{
    private readonly ICategoryRepository _categoryRepository;
    private readonly IUnitOfWork _unitOfWork;

    public AddCategoryCommandHandler(ICategoryRepository categoryRepository, IUnitOfWork unitOfWork)
    {
        _categoryRepository = categoryRepository;
        _unitOfWork = unitOfWork;
    }

    public async Task<Result> Handle(AddCategoryCommand request, CancellationToken cancellationToken)
    {
        var category = new Category() 
        {
            Id = request.Id,
            Title = request.Title
        };

        await _categoryRepository.AddAsync(category);
        await _unitOfWork.SaveChangesAsync(cancellationToken);
        return Result.Success();
    }
}


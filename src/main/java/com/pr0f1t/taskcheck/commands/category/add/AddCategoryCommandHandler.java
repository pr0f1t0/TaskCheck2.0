package com.pr0f1t.taskcheck.commands.category.add;


import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCategoryCommandHandler {
    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;

    public AddCategoryCommandHandler(CategoryRepository categoryRepository,
                                     Mapper<Category, CategoryDto> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public CategoryDto handle(AddCategoryCommand command) {
        CategoryDto categoryDto = CategoryDto.builder()
                .name(command.name())
                .build();

        Category category = categoryRepository.save(mapper.mapFrom(categoryDto));

        return mapper.mapTo(category);
    }

}

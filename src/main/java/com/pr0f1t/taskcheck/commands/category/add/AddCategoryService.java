package com.pr0f1t.taskcheck.commands.category.add;


import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddCategoryService implements Command<AddCategoryCommand, CategoryDto> {
    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;

    public AddCategoryService(CategoryRepository categoryRepository,
                              Mapper<Category, CategoryDto> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<CategoryDto> execute(AddCategoryCommand command) {
        CategoryDto categoryDto = CategoryDto.builder()
                .name(command.getName())
                .user(command.getUser())
                .build();

        Category category = categoryRepository.save(mapper.mapFrom(categoryDto));

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(category));
    }
}

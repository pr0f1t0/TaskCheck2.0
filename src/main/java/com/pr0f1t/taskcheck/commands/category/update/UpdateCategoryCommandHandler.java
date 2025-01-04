package com.pr0f1t.taskcheck.commands.category.update;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class UpdateCategoryCommandHandler {

    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;

    public UpdateCategoryCommandHandler(CategoryRepository categoryRepository,
                                        Mapper<Category, CategoryDto> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public CategoryDto handle(UpdateCategoryCommand command, UUID id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        category.setName(command.name());

        Category savedCategory = categoryRepository.save(category);
        return mapper.mapTo(savedCategory);
    }

}

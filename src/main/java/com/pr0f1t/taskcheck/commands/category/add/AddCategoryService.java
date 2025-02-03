package com.pr0f1t.taskcheck.commands.category.add;


import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.common.SecurityUtil;
import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddCategoryService implements Command<AddCategoryCommand, CategoryDto> {
    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;
    private final AddCategoryCommandValidator validator;

    public AddCategoryService(CategoryRepository categoryRepository,
                              Mapper<Category, CategoryDto> mapper, AddCategoryCommandValidator validator) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<CategoryDto> execute(AddCategoryCommand command) {

        validator.validate(command);
        UUID userId = SecurityUtil.getCurrentUserId()
                .orElseThrow(() -> new SignatureException(UserErrorMessages.USER_NOT_AUTHENTICATED.getMessage()));

        CategoryDto categoryDto = CategoryDto.builder()
                .name(command.getName())
                .userId(userId)
                .build();

        Category saved = categoryRepository.save(mapper.mapFrom(categoryDto));

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(saved));
    }
}

package com.pr0f1t.taskcheck.queries.category.getCategoriesByUserId;

import com.pr0f1t.taskcheck.common.SecurityUtil;
import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.queries.abstractions.Query;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetCategoriesByUserIdService implements Query<GetCategoriesByUserIdQuery, List<CategoryDto>> {

    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;

    public GetCategoriesByUserIdService(CategoryRepository categoryRepository, Mapper<Category, CategoryDto> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<List<CategoryDto>> execute(GetCategoriesByUserIdQuery query) {

        UUID userId = SecurityUtil.getCurrentUserId()
                .orElseThrow(() -> new SignatureException(UserErrorMessages.USER_NOT_AUTHENTICATED.getMessage()));

        List<Category> categories = categoryRepository.findByUserId(userId);
        List<CategoryDto> categoryDtos = categories.stream().map(mapper::mapTo).toList();

        return ResponseEntity.status(HttpStatus.OK).body(categoryDtos);
    }
}

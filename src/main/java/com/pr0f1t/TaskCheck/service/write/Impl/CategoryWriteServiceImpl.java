package com.pr0f1t.TaskCheck.service.write.Impl;

import com.pr0f1t.TaskCheck.domain.entity.Category;
import com.pr0f1t.TaskCheck.repository.CategoryRepository;
import com.pr0f1t.TaskCheck.service.write.CategoryWriteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoryWriteServiceImpl implements CategoryWriteService {

    private final CategoryRepository categoryRepository;

    public CategoryWriteServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(UUID id) {
        categoryRepository.deleteById(id);
    }

}

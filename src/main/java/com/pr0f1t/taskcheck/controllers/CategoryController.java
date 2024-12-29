package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.service.read.CategoryReadService;
import com.pr0f1t.taskcheck.service.write.CategoryWriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CategoryController {
    private final CategoryReadService categoryReadService;
    private final CategoryWriteService categoryWriteService;
    private final Mapper<Category, CategoryDto> categoryMapper;

    public CategoryController(CategoryReadService categoryReadService, CategoryWriteService categoryWriteService,
                              Mapper<Category, CategoryDto> categoryMapper) {
        this.categoryReadService = categoryReadService;
        this.categoryWriteService = categoryWriteService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping(path = "/categories")
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryReadService.getAllCategories();
        return categories.stream().map(categoryMapper::mapTo).toList();
    }

    @GetMapping(path = "/categories/{id}")
    public CategoryDto getCategory(@PathVariable UUID id) {
        Optional<Category> foundCategory = categoryReadService.getCategoryById(id);
        return foundCategory.map(categoryMapper::mapTo).orElse(null);
    }

    @PostMapping(path = "/categories")
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category categoryEntity = categoryMapper.mapFrom(categoryDto);
        Category savedCategoryEntity = categoryWriteService.addCategory(categoryEntity);
        return categoryMapper.mapTo(savedCategoryEntity);
    }

    @PatchMapping(path = "/categories/{id}")
    public CategoryDto partialUpdateCategory(@PathVariable UUID id, CategoryDto categoryDto) {
        Category categoryUpdates = categoryMapper.mapFrom(categoryDto);

        if (!categoryReadService.exists(id)) {
            return null;
        }

        Category updatedCategory = categoryWriteService.partialUpdateCategory(categoryUpdates);
        return categoryMapper.mapTo(updatedCategory);
    }

    @DeleteMapping(path = "/categories/{id}")
    public void deleteCategory(@PathVariable UUID id) {
        categoryWriteService.deleteCategoryById(id);
    }
}

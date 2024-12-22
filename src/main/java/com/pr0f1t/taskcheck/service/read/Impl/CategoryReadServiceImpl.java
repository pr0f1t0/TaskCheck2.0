package com.pr0f1t.taskcheck.service.read.Impl;

import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import com.pr0f1t.taskcheck.service.read.CategoryReadService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Component
public class CategoryReadServiceImpl implements CategoryReadService {

    private final CategoryRepository categoryRepository;

    public CategoryReadServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> getCategoryById(UUID id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public List<Task> getTasksByCategoryId(UUID id) {
        if(categoryRepository.findById(id).isPresent()) {
            return StreamSupport.stream(categoryRepository.findById(id).get().getTasks().spliterator(), false)
                    .toList();
        }else{
            return List.of();
        }

    }

    @Override
    public boolean exists(UUID id) {
        return categoryRepository.existsById(id);
    }

}

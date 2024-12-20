package com.pr0f1t.TaskCheck.service.read;

import com.pr0f1t.TaskCheck.domain.entity.Category;
import com.pr0f1t.TaskCheck.domain.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryReadService {
    Optional<Category> getCategoryById(UUID id);

    List<Category> getAllCategories();

    List<Task> getTasksByCategory(UUID id);

    boolean isExists(UUID id);

    boolean isExists(String name);
}

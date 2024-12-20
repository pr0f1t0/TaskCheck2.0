package com.pr0f1t.TaskCheck.service.read;

import com.pr0f1t.TaskCheck.domain.entity.Category;
import com.pr0f1t.TaskCheck.domain.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface CategoryReadService {
    Optional<Category> getCategoryById(UUID id);

    List<Category> getAllCategories();

    List<Task> getTasksByCategoryId(UUID id);

    boolean exists(UUID id);

}

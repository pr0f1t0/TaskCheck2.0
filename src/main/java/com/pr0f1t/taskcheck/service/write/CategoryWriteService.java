package com.pr0f1t.taskcheck.service.write;

import com.pr0f1t.taskcheck.domain.entity.Category;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CategoryWriteService {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategoryById(UUID id);
}

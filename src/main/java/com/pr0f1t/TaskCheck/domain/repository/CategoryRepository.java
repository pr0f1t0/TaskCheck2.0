package com.pr0f1t.TaskCheck.domain.repository;

import com.pr0f1t.TaskCheck.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {
}

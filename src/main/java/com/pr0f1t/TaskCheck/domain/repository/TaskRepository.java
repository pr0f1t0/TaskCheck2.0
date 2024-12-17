package com.pr0f1t.TaskCheck.domain.repository;

import com.pr0f1t.TaskCheck.domain.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {
}

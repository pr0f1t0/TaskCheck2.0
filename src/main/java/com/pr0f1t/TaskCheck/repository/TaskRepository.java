package com.pr0f1t.TaskCheck.repository;

import com.pr0f1t.TaskCheck.domain.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
}

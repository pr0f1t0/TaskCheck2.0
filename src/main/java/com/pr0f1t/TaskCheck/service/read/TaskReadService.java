package com.pr0f1t.TaskCheck.service.read;

import com.pr0f1t.TaskCheck.domain.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskReadService {
    Optional<Task> getTaskById(UUID id);

    List<Task> getAllTasks();
}

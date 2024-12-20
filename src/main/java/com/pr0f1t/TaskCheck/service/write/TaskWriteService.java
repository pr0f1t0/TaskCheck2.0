package com.pr0f1t.TaskCheck.service.write;

import com.pr0f1t.TaskCheck.domain.entity.Task;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TaskWriteService {
    Task addTask(Task task);

    Task partialUpdateTask(UUID id, Task task);

    void deleteTaskById(UUID id);

    boolean exists(UUID id);
}

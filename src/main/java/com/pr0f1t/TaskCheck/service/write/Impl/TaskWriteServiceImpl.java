package com.pr0f1t.TaskCheck.service.write.Impl;

import com.pr0f1t.TaskCheck.domain.entity.Task;
import com.pr0f1t.TaskCheck.repository.TaskRepository;
import com.pr0f1t.TaskCheck.service.write.TaskWriteService;

import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class TaskWriteServiceImpl implements TaskWriteService {

    private TaskRepository taskRepository;

    public TaskWriteServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task partialUpdateTask(UUID id, Task task) {
        return taskRepository.findById(id).map(taskEntity -> {
            taskEntity.setCompleted(task.isCompleted());
            taskEntity.setImportant(task.isImportant());
            taskEntity.setCategory(task.getCategory());
            taskEntity.setDescription(task.getDescription());
            taskEntity.setDueDate(task.getDueDate());
            taskEntity.setTitle(task.getTitle());
            return taskRepository.save(taskEntity);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public void deleteTaskById(UUID id) {
        taskRepository.deleteById(id);
    }

    @Override
    public boolean exists(UUID id) {
        return taskRepository.existsById(id);
    }


}

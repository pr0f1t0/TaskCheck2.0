package com.pr0f1t.taskcheck.service.read.Impl;

import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import com.pr0f1t.taskcheck.service.read.TaskReadService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Component
public class TaskReadServiceImpl implements TaskReadService {

    private final TaskRepository taskRepository;

    public TaskReadServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> getTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .toList();
    }

    @Override
    public boolean exists(UUID id) {
        return taskRepository.existsById(id);
    }


}

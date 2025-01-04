package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class AddTaskCommandHandler {
    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;

    public AddTaskCommandHandler(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public TaskDto handle(AddTaskCommand command) {
        TaskDto task = TaskDto.builder()
                .title(command.title())
                .description(command.description())
                .dueDate(command.dueDate())
                .isCompleted(command.isCompleted())
                .isImportant(command.isImportant())
                .category(command.category())
                .user(command.user())
                .build();

        Task savedTask = taskRepository.save(mapper.mapFrom(task));

        return mapper.mapTo(savedTask);
    }

}

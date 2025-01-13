package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddTaskService implements Command<AddTaskCommand, TaskDto> {
    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;

    public AddTaskService(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<TaskDto> execute(AddTaskCommand command) {
        TaskDto task = TaskDto.builder()
                .title(command.getTitle())
                .description(command.getDescription())
                .dueDate(command.getDueDate())
                .completed(command.isCompleted())
                .important(command.isImportant())
                .category(command.getCategory())
                .user(command.getUser())
                .build();

        Task savedTask = taskRepository.save(mapper.mapFrom(task));

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(savedTask));
    }

}

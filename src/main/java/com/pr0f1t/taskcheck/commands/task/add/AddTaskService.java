package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.common.SecurityUtil;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AddTaskService implements Command<AddTaskCommand, TaskDto> {
    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;
    private final AddTaskCommandValidator validator;


    public AddTaskService(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper,
                          AddTaskCommandValidator validator) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public ResponseEntity<TaskDto> execute(AddTaskCommand command) {

        validator.validate(command);
        UUID userId = SecurityUtil.getCurrentUserId()
                .orElseThrow(() -> new SignatureException(UserErrorMessages.USER_NOT_FOUND.getMessage()));


        TaskDto task = TaskDto.builder()
                .title(command.getTitle())
                .description(command.getDescription())
                .dueDate(command.getDueDate())
                .createdAt(LocalDateTime.now())
                .completed(false)
                .important(command.isImportant())
                .categoryId(command.getCategoryId())
                .userId(userId)
                .build();

        Task saved = taskRepository.save(mapper.mapFrom(task));

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(saved));
    }

}

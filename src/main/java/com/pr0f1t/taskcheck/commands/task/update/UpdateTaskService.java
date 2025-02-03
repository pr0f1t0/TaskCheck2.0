package com.pr0f1t.taskcheck.commands.task.update;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.exceptions.errorMessages.TaskErrorMessages;
import com.pr0f1t.taskcheck.exceptions.task.TaskNotFoundException;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UpdateTaskService implements Command<UpdateTaskCommand, TaskDto> {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;
    private final UpdateTaskCommandValidator validator;

    public UpdateTaskService(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper,
                             UpdateTaskCommandValidator validator) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public ResponseEntity<TaskDto> execute(UpdateTaskCommand command) {

        validator.validate(command);

        Task taskOptional = taskRepository.findById(command.getId())
                .orElseThrow(() -> new TaskNotFoundException(TaskErrorMessages.TASK_NOT_FOUND.getMessage()));

        Task updatedTask = mapper.mapFrom(command.getTaskDto());
        updatedTask.setId(command.getId());
        Task saved = taskRepository.save(updatedTask);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(saved));
    }

}

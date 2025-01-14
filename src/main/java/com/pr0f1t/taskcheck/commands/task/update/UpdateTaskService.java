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

import java.util.Optional;


@Service
public class UpdateTaskService implements Command<UpdateTaskCommand, TaskDto> {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;

    public UpdateTaskService(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<TaskDto> execute(UpdateTaskCommand command) {
        Optional<Task> taskOptional = taskRepository.findById(command.getId());

        if(taskOptional.isPresent()) {
            Task updatedTask = mapper.mapFrom(command.getTaskDto());
            updatedTask.setId(command.getId());
            Task savedTaskUpdates = taskRepository.save(updatedTask);
            return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(savedTaskUpdates));
        }else {
            throw new TaskNotFoundException(TaskErrorMessages.TASK_NOT_FOUND.getMessage());
        }

    }

}

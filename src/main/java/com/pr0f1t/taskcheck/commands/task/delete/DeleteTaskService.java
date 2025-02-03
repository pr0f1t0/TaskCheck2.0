package com.pr0f1t.taskcheck.commands.task.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.exceptions.errorMessages.TaskErrorMessages;
import com.pr0f1t.taskcheck.exceptions.task.TaskNotFoundException;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskService implements Command<DeleteTaskCommand, Void> {
    private final TaskRepository taskRepository;
    private final DeleteTaskCommandValidator validator;

    public DeleteTaskService(TaskRepository taskRepository, DeleteTaskCommandValidator validator) {
        this.taskRepository = taskRepository;
        this.validator = validator;
    }

    public ResponseEntity<Void> execute(DeleteTaskCommand command){
        validator.validate(command);
        if(!taskRepository.existsById(command.getId())){
            throw new TaskNotFoundException(TaskErrorMessages.TASK_NOT_FOUND.getMessage());
        }
        taskRepository.deleteById(command.getId());

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

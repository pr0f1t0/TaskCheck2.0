package com.pr0f1t.taskcheck.commands.task.update;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.TaskErrorMessages;
import com.pr0f1t.taskcheck.exceptions.task.TaskNotValidException;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskCommandValidator implements Validator<UpdateTaskCommand> {
    @Override
    public void validate(UpdateTaskCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if(command.getTaskDto().getTitle().length() < 3 || command.getTaskDto().getTitle().length() > 20){
            throw new TaskNotValidException(TaskErrorMessages.TASK_TITLE_NOT_VALID.getMessage());
        }

    }
}

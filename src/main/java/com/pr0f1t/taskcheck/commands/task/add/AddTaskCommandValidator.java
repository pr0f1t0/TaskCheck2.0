package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.TaskErrorMessages;
import com.pr0f1t.taskcheck.exceptions.task.TaskNotValidException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AddTaskCommandValidator implements Validator<AddTaskCommand> {

    @Override
    public void validate(AddTaskCommand command) {

        if (command == null) {
            throw new TaskNotValidException(TaskErrorMessages.TASK_NOT_VALID.getMessage());
        }

        if(command.getTitle().length() < 3 || command.getTitle().length() > 20){
            throw new TaskNotValidException(TaskErrorMessages.TASK_TITLE_NOT_VALID.getMessage());
        }
        if(command.getDueDate().isBefore(LocalDateTime.now())){
            throw new TaskNotValidException(TaskErrorMessages.TASK_DUE_DATE_NOT_VALID.getMessage());
        }
    }

}

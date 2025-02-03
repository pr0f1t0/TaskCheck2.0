package com.pr0f1t.taskcheck.commands.task.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.GeneralErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class DeleteTaskCommandValidator implements Validator<DeleteTaskCommand> {

    @Override
    public void validate(DeleteTaskCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException(GeneralErrorMessages.ID_REQUIRED.getMessage());
        }
    }

}

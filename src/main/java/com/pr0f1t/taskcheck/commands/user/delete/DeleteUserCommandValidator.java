package com.pr0f1t.taskcheck.commands.user.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.GeneralErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserCommandValidator implements Validator<DeleteUserCommand> {
    @Override
    public void validate(DeleteUserCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException(GeneralErrorMessages.ID_REQUIRED.getMessage());
        }
    }
}

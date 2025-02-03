package com.pr0f1t.taskcheck.commands.user.login;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class LoginUserCommandValidator implements Validator<LoginUserCommand> {
    @Override
    public void validate(LoginUserCommand command) {
        if (command.getEmail().length() < 3 || command.getEmail().length() > 20) {
            throw new IllegalArgumentException(UserErrorMessages.USER_EMAIL_NOT_VALID.getMessage());
        }
    }
}

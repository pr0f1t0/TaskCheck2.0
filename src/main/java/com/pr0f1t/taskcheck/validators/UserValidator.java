package com.pr0f1t.taskcheck.validators;

import com.pr0f1t.taskcheck.commands.user.add.AddUserCommand;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.exceptions.user.UserNotValidException;

public class UserValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$\n";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n";

    private UserValidator() {
    }

    public static void validate(AddUserCommand command) {

        if (!command.getPassword().matches(PASSWORD_PATTERN)) {
            throw new UserNotValidException(UserErrorMessages.USER_PASSWORD_NOT_VALID.getMessage());
        }
        if (!command.getEmail().matches(EMAIL_PATTERN)) {
            throw new UserNotValidException(UserErrorMessages.USER_EMAIL_NOT_VALID.getMessage());
        }
        if (command.getUsername().length() < 3 || command.getUsername().length() > 15) {
            throw new UserNotValidException(UserErrorMessages.USER_USERNAME_NOT_VALID.getMessage());
        }

    }

}

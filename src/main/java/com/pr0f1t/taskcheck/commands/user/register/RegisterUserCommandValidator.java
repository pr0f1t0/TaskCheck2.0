package com.pr0f1t.taskcheck.commands.user.register;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.exceptions.user.UserNotValidException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class RegisterUserCommandValidator implements Validator<RegisterUserCommand> {
    private final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    @Override
    public void validate(RegisterUserCommand command) {

        if(command.getUsername().length() < 3 || command.getUsername().length() > 20){
            throw new UserNotValidException(UserErrorMessages.USER_USERNAME_NOT_VALID.getMessage());
        }

        if(isNotValid(PASSWORD_PATTERN.pattern(), command.getPassword())){
            throw new UserNotValidException(UserErrorMessages.USER_PASSWORD_NOT_VALID.getMessage());
        }
        if(isNotValid(EMAIL_PATTERN.pattern(), command.getEmail())){
            throw new UserNotValidException(UserErrorMessages.USER_EMAIL_NOT_VALID.getMessage());
        }
    }

    private boolean isNotValid(String pattern, String values){
        return !Pattern.compile(pattern).matcher(values).matches();
    }
}

package com.pr0f1t.taskcheck.commands.user.update;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.commands.validation.UserDtoValidator;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.exceptions.errorMessages.GeneralErrorMessages;
import org.springframework.stereotype.Component;


@Component
public class UpdateUserCommandValidator implements Validator<UpdateUserCommand> {

    private final UserDtoValidator userDtoValidator;

    public UpdateUserCommandValidator(UserDtoValidator userDtoValidator) {
        this.userDtoValidator = userDtoValidator;
    }

    @Override
    public void validate(UpdateUserCommand command) {

        UserDto userDto = command.getUserDto();

        if (command.getId() == null) {
            throw new IllegalArgumentException(GeneralErrorMessages.ID_REQUIRED.getMessage());
        }

        userDtoValidator.validate(userDto);

    }

}

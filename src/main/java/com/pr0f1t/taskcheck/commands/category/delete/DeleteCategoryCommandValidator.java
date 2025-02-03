package com.pr0f1t.taskcheck.commands.category.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.errorMessages.GeneralErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryCommandValidator implements Validator<DeleteCategoryCommand> {
    @Override
    public void validate(DeleteCategoryCommand command) {
        if (command.getId() == null) {
            throw new IllegalArgumentException(GeneralErrorMessages.ID_REQUIRED.getMessage());
        }
    }
}

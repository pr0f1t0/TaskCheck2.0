package com.pr0f1t.taskcheck.commands.category.update;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.category.CategoryNotFoundException;
import com.pr0f1t.taskcheck.exceptions.errorMessages.CategoryErrorMessages;
import com.pr0f1t.taskcheck.exceptions.errorMessages.GeneralErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class UpdateCategoryCommandValidator implements Validator<UpdateCategoryCommand> {
    @Override
    public void validate(UpdateCategoryCommand command) {
        if (command.getId() == null) {
            throw new CategoryNotFoundException(GeneralErrorMessages.ID_REQUIRED.getMessage());
        }
        if (command.getCategoryDto().getName() == null) {
            throw new CategoryNotFoundException(CategoryErrorMessages.CATEGORY_NAME_NOT_VALID.getMessage());
        }
    }
}

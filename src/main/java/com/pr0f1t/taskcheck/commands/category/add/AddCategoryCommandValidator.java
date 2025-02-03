package com.pr0f1t.taskcheck.commands.category.add;

import com.pr0f1t.taskcheck.commands.abstractions.Validator;
import com.pr0f1t.taskcheck.exceptions.category.CategoryNotValidException;
import com.pr0f1t.taskcheck.exceptions.errorMessages.CategoryErrorMessages;
import org.springframework.stereotype.Component;

@Component
public class AddCategoryCommandValidator implements Validator<AddCategoryCommand> {
    @Override
    public void validate(AddCategoryCommand command) {

        if(command.getName() == null || command.getName().isEmpty()){
            throw new CategoryNotValidException(CategoryErrorMessages.CATEGORY_NAME_NOT_VALID.getMessage());
        }

        if (command.getName().length() < 4 || command.getName().length() > 15) {
            throw new CategoryNotValidException(CategoryErrorMessages.CATEGORY_NAME_NOT_VALID.getMessage());
        }
    }
}

package com.pr0f1t.taskcheck.commands.category.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.exceptions.category.CategoryNotFoundException;
import com.pr0f1t.taskcheck.exceptions.errorMessages.CategoryErrorMessages;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService implements Command<DeleteCategoryCommand, Void> {

    private final CategoryRepository categoryRepository;

    public DeleteCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Void> execute(DeleteCategoryCommand command) {

        if(!categoryRepository.existsById(command.getId())) {
            throw new CategoryNotFoundException(CategoryErrorMessages.CATEGORY_NOT_FOUND.getMessage());
        }

        categoryRepository.deleteById(command.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

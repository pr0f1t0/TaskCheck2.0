package com.pr0f1t.taskcheck.commands.category.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryRepository.deleteById(command.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

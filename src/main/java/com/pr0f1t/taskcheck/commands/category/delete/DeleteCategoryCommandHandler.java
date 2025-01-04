package com.pr0f1t.taskcheck.commands.category.delete;

import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryCommandHandler {

    private final CategoryRepository categoryRepository;

    public DeleteCategoryCommandHandler(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResponseEntity<Void> handle(DeleteCategoryCommand command) {

        if(!categoryRepository.existsById(command.id())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoryRepository.deleteById(command.id());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

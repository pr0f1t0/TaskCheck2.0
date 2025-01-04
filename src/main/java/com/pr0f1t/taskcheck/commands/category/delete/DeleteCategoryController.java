package com.pr0f1t.taskcheck.commands.category.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteCategoryController {

    private final DeleteCategoryCommandHandler deleteCategoryCommandHandler;

    public DeleteCategoryController(DeleteCategoryCommandHandler deleteCategoryCommandHandler) {
        this.deleteCategoryCommandHandler = deleteCategoryCommandHandler;
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable UUID id) {
        DeleteCategoryCommand command = new DeleteCategoryCommand(id);
        deleteCategoryCommandHandler.handle(command);
    }
}

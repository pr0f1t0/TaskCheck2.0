package com.pr0f1t.taskcheck.commands.category.update;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UpdateCategoryController {

    private final UpdateCategoryCommandHandler updateCategoryCommandHandler;

    public UpdateCategoryController(UpdateCategoryCommandHandler updateCategoryCommandHandler) {
        this.updateCategoryCommandHandler = updateCategoryCommandHandler;
    }

    @PatchMapping("/categories/{categoryId}")
    public void updateCategory(@RequestBody UpdateCategoryCommand updateCategoryCommand, @PathVariable UUID id) {
        updateCategoryCommandHandler.handle(updateCategoryCommand, id);
    }

}

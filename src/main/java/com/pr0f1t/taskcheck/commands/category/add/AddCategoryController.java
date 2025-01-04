package com.pr0f1t.taskcheck.commands.category.add;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddCategoryController {

    private final AddCategoryCommandHandler addCategoryCommandHandler;

    public AddCategoryController(AddCategoryCommandHandler addCategoryCommandHandler) {
        this.addCategoryCommandHandler = addCategoryCommandHandler;
    }

    @PostMapping("/categories")
    public void addCategory(AddCategoryCommand addCategoryCommand) {
        addCategoryCommandHandler.handle(addCategoryCommand);
    }
}

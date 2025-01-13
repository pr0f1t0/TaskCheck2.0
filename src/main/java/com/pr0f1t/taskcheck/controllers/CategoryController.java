package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.commands.category.add.AddCategoryCommand;
import com.pr0f1t.taskcheck.commands.category.add.AddCategoryService;
import com.pr0f1t.taskcheck.commands.category.delete.DeleteCategoryCommand;
import com.pr0f1t.taskcheck.commands.category.delete.DeleteCategoryService;
import com.pr0f1t.taskcheck.commands.category.update.UpdateCategoryCommand;
import com.pr0f1t.taskcheck.commands.category.update.UpdateCategoryService;
import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CategoryController {

    private final AddCategoryService addCategoryService;
    private final DeleteCategoryService deleteCategoryService;
    private final UpdateCategoryService updateCategoryService;

    public CategoryController(AddCategoryService addCategoryService, DeleteCategoryService deleteCategoryService,
                              UpdateCategoryService updateCategoryService) {
        this.addCategoryService = addCategoryService;
        this.deleteCategoryService = deleteCategoryService;
        this.updateCategoryService = updateCategoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> addCategory(AddCategoryCommand addCategoryCommand) {
        return addCategoryService.execute(addCategoryCommand);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id) {
        return deleteCategoryService.execute(new DeleteCategoryCommand(id));
    }

    @PatchMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID id) {
        return updateCategoryService.execute(new UpdateCategoryCommand(categoryDto, id));
    }


}

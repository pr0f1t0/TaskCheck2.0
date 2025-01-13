package com.pr0f1t.taskcheck.commands.category.update;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateCategoryService implements Command<UpdateCategoryCommand, CategoryDto> {

    private final CategoryRepository categoryRepository;
    private final Mapper<Category, CategoryDto> mapper;

    public UpdateCategoryService(CategoryRepository categoryRepository,
                                 Mapper<Category, CategoryDto> mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<CategoryDto> execute(UpdateCategoryCommand command) {

        Optional<Category> categoryOptional = categoryRepository.findById(command.getId());

        if(categoryOptional.isPresent()){
            Category updatedCategory = mapper.mapFrom(command.getCategoryDto());
            updatedCategory.setId(command.getId());
            Category savedCategoryUpdates = categoryRepository.save(updatedCategory);

            return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(savedCategoryUpdates));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

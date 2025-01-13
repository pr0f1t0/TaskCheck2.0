package com.pr0f1t.taskcheck.commands.category.update;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateCategoryCommand{

    private CategoryDto categoryDto;

    private UUID id;

}

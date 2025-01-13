package com.pr0f1t.taskcheck.commands.category.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCategoryCommand {
    private UUID id;
}

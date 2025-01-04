package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.dto.UserDto;

import java.time.LocalDateTime;

public record AddTaskCommand(
        String title,
        String description,
        LocalDateTime dueDate,
        boolean isCompleted,
        boolean isImportant,
        CategoryDto category,
        UserDto user
)
{}

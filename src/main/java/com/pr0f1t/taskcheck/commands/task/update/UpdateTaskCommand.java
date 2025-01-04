package com.pr0f1t.taskcheck.commands.task.update;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.dto.UserDto;

import java.time.LocalDateTime;

public record UpdateTaskCommand(
        String title,
        String description,
        LocalDateTime dueDate,
        boolean completed,
        boolean important,
        CategoryDto category,
        UserDto user
) {}

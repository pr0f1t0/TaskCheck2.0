package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class AddTaskCommand{

        private String title;

        private String description;

        private LocalDateTime dueDate;

        private boolean completed;

        private boolean important;

        private CategoryDto category;

        private UserDto user;
}

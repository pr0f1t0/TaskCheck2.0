package com.pr0f1t.taskcheck.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDto {

    public String title;

    public String description;

    public LocalDateTime dueDate;

    public boolean isCompleted;

    public boolean isImportant;

    public CategoryDto category;

    public UserDto user;

}

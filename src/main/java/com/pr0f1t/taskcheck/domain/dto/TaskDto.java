package com.pr0f1t.taskcheck.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDto {
    public UUID id;

    public String title;

    public String description;

    public LocalDateTime createdAt;

    public LocalDateTime dueDate;

    public boolean isCompleted;

    public boolean isImportant;

    public CategoryDto category;

    public UserDto user;

}

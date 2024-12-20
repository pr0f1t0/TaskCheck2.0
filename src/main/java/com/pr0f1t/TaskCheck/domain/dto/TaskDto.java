package com.pr0f1t.TaskCheck.domain.dto;

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
    public UUID Id;

    public String Title;

    public String Description;

    public LocalDateTime CreatedAt;

    public LocalDateTime DueDate;

    public boolean IsCompleted;

    public boolean IsImportant;

    public CategoryDto Category;

    public UserDto User;

}

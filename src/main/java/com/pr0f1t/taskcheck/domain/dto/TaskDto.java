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

    public LocalDateTime dueDate;

    public LocalDateTime createdAt;

    public boolean completed;

    public boolean important;

    public UUID categoryId;

    public UUID userId;

}

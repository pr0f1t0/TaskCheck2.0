package com.pr0f1t.taskcheck.queries.task.getTasksByCategoryId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetTasksByCategoryIdQuery {
    UUID categoryId;
}

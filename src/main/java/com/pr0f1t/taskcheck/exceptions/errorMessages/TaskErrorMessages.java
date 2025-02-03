package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum TaskErrorMessages {
    TASK_NOT_FOUND("Task not found"),
    TASK_NOT_VALID("Task cannot be empty"),
    TASK_TITLE_NOT_VALID("Task title must be between 3 and 20 characters long"),
    TASK_DUE_DATE_NOT_VALID("Task due date must be in the future");

    private final String message;

    TaskErrorMessages(String message) {
        this.message = message;
    }
}

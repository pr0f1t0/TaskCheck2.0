package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum TaskErrorMessages {
    TASK_NOT_FOUND("Task not found");

    private final String message;

    TaskErrorMessages(String message) {
        this.message = message;
    }
}

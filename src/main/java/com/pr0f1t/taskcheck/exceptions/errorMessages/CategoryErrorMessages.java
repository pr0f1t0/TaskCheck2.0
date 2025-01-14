package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum CategoryErrorMessages {
    CATEGORY_NOT_FOUND("Category not found");

    private final String message;

    CategoryErrorMessages(String message) {
        this.message = message;
    }
}

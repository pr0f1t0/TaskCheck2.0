package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum CategoryErrorMessages {
    CATEGORY_NOT_FOUND("Category not found"),
    CATEGORY_NAME_NOT_VALID("Category name must be between 4 and 15 characters long");

    private final String message;

    CategoryErrorMessages(String message) {
        this.message = message;
    }
}

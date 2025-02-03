package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum UserErrorMessages {
    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists"),
    USER_NOT_AUTHENTICATED("User not authenticated"),
    USER_PASSWORD_NOT_VALID("Password should contain at least one uppercase letter, " +
            "one lowercase letter, one digit, one special character and be at least 8 characters long"),
    USER_EMAIL_NOT_VALID("Email is not valid"),
    USER_USERNAME_NOT_VALID("Username must be between 3 and 15 characters long");

    private final String message;

    UserErrorMessages(String message) {
        this.message = message;
    }
}

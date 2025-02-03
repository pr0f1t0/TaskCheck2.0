package com.pr0f1t.taskcheck.exceptions.errorMessages;

import lombok.Getter;

@Getter
public enum GeneralErrorMessages {
    ID_REQUIRED("Id is required");

    private final String message;

    GeneralErrorMessages(String message) {
        this.message = message;
    }
}

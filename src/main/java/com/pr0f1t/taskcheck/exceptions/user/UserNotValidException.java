package com.pr0f1t.taskcheck.exceptions.user;

public class UserNotValidException extends RuntimeException{
    public UserNotValidException(String message) {
        super(message);
    }
}

package com.pr0f1t.taskcheck.commands.abstractions;

public interface Validator<T> {
    void validate(T command);
}

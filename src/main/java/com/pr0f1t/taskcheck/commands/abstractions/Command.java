package com.pr0f1t.taskcheck.commands.abstractions;

import org.springframework.http.ResponseEntity;

public interface Command <I, O>{
    public ResponseEntity<O> execute(I input);
}

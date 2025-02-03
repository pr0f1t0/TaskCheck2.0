package com.pr0f1t.taskcheck.commands.abstractions;

import org.springframework.http.ResponseEntity;

public interface Command <I, O>{
    ResponseEntity<O> execute(I input);
}

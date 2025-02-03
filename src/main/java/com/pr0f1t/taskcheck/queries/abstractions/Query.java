package com.pr0f1t.taskcheck.queries.abstractions;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> execute(I input);
}

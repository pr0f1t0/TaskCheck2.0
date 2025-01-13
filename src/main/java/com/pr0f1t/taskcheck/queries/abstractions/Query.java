package com.pr0f1t.taskcheck.queries.abstractions;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    public ResponseEntity<O> execute(I input);
}

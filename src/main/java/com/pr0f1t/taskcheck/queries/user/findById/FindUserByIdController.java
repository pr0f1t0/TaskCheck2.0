package com.pr0f1t.taskcheck.queries.user.findById;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FindUserByIdController {

    private final FindUserByIdQueryHandler queryHandler;

    public FindUserByIdController(FindUserByIdQueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        FindUserByIdQuery query = new FindUserByIdQuery(id);
        return queryHandler.handle(query);
    }
}

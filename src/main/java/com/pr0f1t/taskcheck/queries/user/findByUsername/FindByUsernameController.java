package com.pr0f1t.taskcheck.queries.user.findByUsername;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindByUsernameController {
    private final FindUserByUsernameQueryHandler findUserByUsernameQueryHandler;

    public FindByUsernameController(FindUserByUsernameQueryHandler findUserByUsernameQueryHandler) {
        this.findUserByUsernameQueryHandler = findUserByUsernameQueryHandler;
    }

    @GetMapping("/users/username/{username}")
    public ResponseEntity<UserDto> handle(@PathVariable String username) {
        FindUserByUsernameQuery query = new FindUserByUsernameQuery(username);
        return findUserByUsernameQueryHandler.handle(query);
    }
}

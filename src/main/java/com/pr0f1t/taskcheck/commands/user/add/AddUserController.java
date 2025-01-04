package com.pr0f1t.taskcheck.commands.user.add;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddUserController {

    private final AddUserCommandHandler addUserCommandHandler;

    public AddUserController(AddUserCommandHandler addUserCommandHandler) {
        this.addUserCommandHandler = addUserCommandHandler;
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody AddUserCommand command) {
        return addUserCommandHandler.handle(command);
    }
}

package com.pr0f1t.taskcheck.commands.user.update;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UpdateUserController {
    private final UpdateUserCommandHandler updateUserCommandHandler;

    public UpdateUserController(UpdateUserCommandHandler updateUserCommandHandler) {
        this.updateUserCommandHandler = updateUserCommandHandler;
    }

    @PatchMapping("/users/{userId}")
    public void updateUser(@RequestBody UpdateUserCommand updateUserCommand, @PathVariable UUID userId) {
        updateUserCommandHandler.handle(updateUserCommand, userId);
    }

}

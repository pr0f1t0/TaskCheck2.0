package com.pr0f1t.taskcheck.commands.user.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteUserController {

    private final DeleteUserCommandHandler deleteUserCommandHandler;

    public DeleteUserController(DeleteUserCommandHandler deleteUserCommandHandler) {
        this.deleteUserCommandHandler = deleteUserCommandHandler;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) {
        DeleteUserCommand command = new DeleteUserCommand(id);
        deleteUserCommandHandler.handle(command);
    }

}

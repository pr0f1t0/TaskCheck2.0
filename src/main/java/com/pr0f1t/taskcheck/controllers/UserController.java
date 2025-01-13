package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.commands.user.add.AddUserCommand;
import com.pr0f1t.taskcheck.commands.user.add.AddUserService;
import com.pr0f1t.taskcheck.commands.user.delete.DeleteUserCommand;
import com.pr0f1t.taskcheck.commands.user.delete.DeleteUserService;
import com.pr0f1t.taskcheck.commands.user.update.UpdateUserCommand;
import com.pr0f1t.taskcheck.commands.user.update.UpdateUserService;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    private final AddUserService addUserService;
    private final DeleteUserService deleteUserService;
    private final UpdateUserService updateUserService;

    public UserController(AddUserService addUserService, DeleteUserService deleteUserService,
                          UpdateUserService updateUserService) {
        this.addUserService = addUserService;
        this.deleteUserService = deleteUserService;
        this.updateUserService = updateUserService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDto> addUser(@RequestBody AddUserCommand command) {
        return addUserService.execute(command);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@RequestBody DeleteUserCommand command) {
        return deleteUserService.execute(command);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                              @PathVariable UUID userId) {
       return updateUserService.execute(new UpdateUserCommand(userDto, userId));
    }

}

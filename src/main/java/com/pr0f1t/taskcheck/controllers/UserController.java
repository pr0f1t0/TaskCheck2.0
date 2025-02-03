package com.pr0f1t.taskcheck.controllers;


import com.pr0f1t.taskcheck.commands.user.delete.DeleteUserCommand;
import com.pr0f1t.taskcheck.commands.user.delete.DeleteUserService;
import com.pr0f1t.taskcheck.commands.user.update.UpdateUserCommand;
import com.pr0f1t.taskcheck.commands.user.update.UpdateUserService;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.dto.UserInfoDto;
import com.pr0f1t.taskcheck.queries.user.loggedInUserInfo.CurrentUserInfoQuery;
import com.pr0f1t.taskcheck.queries.user.loggedInUserInfo.CurrentUserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    private final DeleteUserService deleteUserService;
    private final UpdateUserService updateUserService;
    private final CurrentUserInfoService currentUserInfoService;

    public UserController(DeleteUserService deleteUserService,
                          UpdateUserService updateUserService,
                          CurrentUserInfoService currentUserInfoService) {
        this.deleteUserService = deleteUserService;
        this.updateUserService = updateUserService;
        this.currentUserInfoService = currentUserInfoService;
    }



    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@RequestBody DeleteUserCommand command) {
        return deleteUserService.execute(command);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                              @PathVariable UUID id) {
       return updateUserService.execute(new UpdateUserCommand(userDto, id));
    }

    @GetMapping("/users/me")
    public ResponseEntity<UserInfoDto> getCurrentUserInfo() {
        return currentUserInfoService.execute(new CurrentUserInfoQuery());
    }
}

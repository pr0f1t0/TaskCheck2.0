package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.service.read.UserReadService;
import com.pr0f1t.taskcheck.service.write.UserWriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class UserController {
    private final UserReadService userService;
    private final UserWriteService userWriteService;
    private final Mapper<User, UserDto> userMapper;

    public UserController(UserReadService userReadService, UserWriteService userWriteService, Mapper<User, UserDto> userMapper) {
        this.userService = userReadService;
        this.userWriteService = userWriteService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        Optional<User> foundUser = userService.getUserById(id);
        return foundUser.map(user -> {
            UserDto userDto = userMapper.mapTo(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/users")
    public List<UserDto> getUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(userMapper::mapTo).toList();
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        User userEntity = userMapper.mapFrom(userDto);
        User savedUserEntity = userWriteService.addUser(userEntity);
        return userMapper.mapTo(savedUserEntity);
    }

    @PatchMapping(path = "/users/{id}")
    public ResponseEntity<UserDto> partialUpdateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        User userUpdates = userMapper.mapFrom(userDto);

        if (!userWriteService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        User updatedUser = userWriteService.partialUpdateUser(userUpdates);
        return new ResponseEntity<>(userMapper.mapTo(updatedUser), HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        if (!userWriteService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userWriteService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

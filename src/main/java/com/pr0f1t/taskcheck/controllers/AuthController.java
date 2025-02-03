package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.commands.user.register.RegisterUserCommand;
import com.pr0f1t.taskcheck.commands.user.register.RegisterUserService;
import com.pr0f1t.taskcheck.commands.user.login.LoginUserCommand;
import com.pr0f1t.taskcheck.commands.user.login.LoginUserService;
import com.pr0f1t.taskcheck.responses.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final RegisterUserService registerUserService;
    private final LoginUserService loginUserService;

    public AuthController(RegisterUserService registerUserService, LoginUserService loginUserService) {
        this.registerUserService = registerUserService;
        this.loginUserService = loginUserService;

    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterUserCommand command) {
        return registerUserService.execute(command);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginUserCommand command) {
        return loginUserService.execute(command);
    }
}

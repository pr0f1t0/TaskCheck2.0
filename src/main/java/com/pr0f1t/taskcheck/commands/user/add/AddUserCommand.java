package com.pr0f1t.taskcheck.commands.user.add;

public record AddUserCommand(
        String username,
        String password,
        String email) {}

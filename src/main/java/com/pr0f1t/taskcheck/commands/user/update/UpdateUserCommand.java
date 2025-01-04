package com.pr0f1t.taskcheck.commands.user.update;

public record UpdateUserCommand(
    String username,
    String password,
    String email
) {}

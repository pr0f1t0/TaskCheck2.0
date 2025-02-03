package com.pr0f1t.taskcheck.commands.user.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserCommand {

    private String username;

    private String password;

    private String email;

}

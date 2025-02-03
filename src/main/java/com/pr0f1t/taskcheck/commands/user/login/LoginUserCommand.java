package com.pr0f1t.taskcheck.commands.user.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserCommand {
    private String email;
    private String password;

}

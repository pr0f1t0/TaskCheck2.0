package com.pr0f1t.taskcheck.commands.user.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserCommand{

    private String username;

    private String password;

    private String email;

}

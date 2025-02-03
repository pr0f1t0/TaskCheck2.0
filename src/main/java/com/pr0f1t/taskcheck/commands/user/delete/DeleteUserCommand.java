package com.pr0f1t.taskcheck.commands.user.delete;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserCommand{
        private UUID id;
}

package com.pr0f1t.taskcheck.commands.user.update;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserCommand {
    private UserDto userDto;
    private UUID id;

}

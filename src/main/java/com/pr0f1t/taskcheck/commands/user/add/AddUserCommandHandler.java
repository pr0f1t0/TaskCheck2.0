package com.pr0f1t.taskcheck.commands.user.add;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddUserCommandHandler {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public AddUserCommandHandler(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDto handle(AddUserCommand command) {
        UserDto userDto = UserDto.builder()
                .username(command.username())
                .password(command.password())
                .email(command.email())
                .build();

        User user = mapper.mapFrom(userDto);
        User savedUser = userRepository.save(user);
        return mapper.mapTo(savedUser);
    }
}

package com.pr0f1t.taskcheck.commands.user.add;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddUserService implements Command<AddUserCommand, UserDto> {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public AddUserService(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<UserDto> execute(AddUserCommand command) {

        UserDto userDto = UserDto.builder()
                .username(command.getUsername())
                .password(command.getPassword())
                .email(command.getEmail())
                .build();

        User user = mapper.mapFrom(userDto);
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(savedUser));
    }
}

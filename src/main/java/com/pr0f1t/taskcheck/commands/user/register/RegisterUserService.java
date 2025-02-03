package com.pr0f1t.taskcheck.commands.user.register;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.exceptions.user.UserExistsException;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements Command<RegisterUserCommand, Void> {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserService(UserRepository userRepository, Mapper<User, UserDto> mapper,
                               PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;

    }

    public ResponseEntity<Void> execute(RegisterUserCommand command) {

        if(userRepository.existsByEmail(command.getEmail())) {
            throw new UserExistsException(UserErrorMessages.USER_ALREADY_EXISTS.getMessage());
        }

        UserDto userDto = UserDto.builder()
                .username(command.getUsername())
                .password(passwordEncoder.encode(command.getPassword()))
                .email(command.getEmail())
                .build();

        User user = mapper.mapFrom(userDto);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

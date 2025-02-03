package com.pr0f1t.taskcheck.commands.user.update;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.exceptions.user.UserNotFoundException;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDto> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Mapper<User, UserDto> mapper;

    public UpdateUserService(UserRepository userRepository,
                             PasswordEncoder passwordEncoder, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    public ResponseEntity<UserDto> execute(UpdateUserCommand command) {
        User user = userRepository.findById(command.getId())
                .orElseThrow(() -> new UserNotFoundException(UserErrorMessages.USER_NOT_FOUND.getMessage()));

        UserDto userChanges = command.getUserDto();

        user.setUsername(userChanges.getUsername());
        user.setEmail(userChanges.getEmail());
        user.setPassword(passwordEncoder.encode(userChanges.getPassword()));
        User saved = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(saved));
    }

}

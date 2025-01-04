package com.pr0f1t.taskcheck.commands.user.update;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class UpdateUserCommandHandler {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public UpdateUserCommandHandler(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public UserDto handle(UpdateUserCommand command, UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        user.setUsername(command.username());
        user.setEmail(command.email());
        user.setPassword(command.password());

        User savedUserUpdates = userRepository.save(user);
        return mapper.mapTo(savedUserUpdates);
    }

}

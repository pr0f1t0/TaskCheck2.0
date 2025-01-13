package com.pr0f1t.taskcheck.commands.user.update;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateUserService implements Command<UpdateUserCommand, UserDto> {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public UpdateUserService(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<UserDto> execute(UpdateUserCommand command) {
        Optional<User> userOptional = userRepository.findById(command.getId());

        if(userOptional.isPresent()){
            User updatedUser = mapper.mapFrom(command.getUserDto());
            updatedUser.setId(command.getId());
            User savedUserUpdates = userRepository.save(updatedUser);

            return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(savedUserUpdates));
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

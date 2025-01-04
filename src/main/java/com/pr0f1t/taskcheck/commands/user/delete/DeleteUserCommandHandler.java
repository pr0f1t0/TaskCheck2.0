package com.pr0f1t.taskcheck.commands.user.delete;

import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserCommandHandler {

    private final UserRepository userRepository;

    public DeleteUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Void> handle(DeleteUserCommand command) {

        if (!userRepository.existsById(command.id())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(command.id());

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

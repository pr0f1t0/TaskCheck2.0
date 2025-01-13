package com.pr0f1t.taskcheck.commands.user.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService implements Command<DeleteUserCommand, Void> {

    private final UserRepository userRepository;

    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Void> execute(DeleteUserCommand command) {

        if (userRepository.existsById(command.getId())) {
            userRepository.deleteById(command.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

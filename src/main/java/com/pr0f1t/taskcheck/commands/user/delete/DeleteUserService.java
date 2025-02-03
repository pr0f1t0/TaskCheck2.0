package com.pr0f1t.taskcheck.commands.user.delete;

import com.pr0f1t.taskcheck.commands.abstractions.Command;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.exceptions.user.UserNotFoundException;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService implements Command<DeleteUserCommand, Void> {

    private final UserRepository userRepository;
    private final DeleteUserCommandValidator validator;

    public DeleteUserService(UserRepository userRepository, DeleteUserCommandValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public ResponseEntity<Void> execute(DeleteUserCommand command) {

        validator.validate(command);

        if (!userRepository.existsById(command.getId())) {
            throw new UserNotFoundException(UserErrorMessages.USER_NOT_FOUND.getMessage());
        }

        userRepository.deleteById(command.getId());
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}

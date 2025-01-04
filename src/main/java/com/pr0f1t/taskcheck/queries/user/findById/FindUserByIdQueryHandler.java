package com.pr0f1t.taskcheck.queries.user.findById;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUserByIdQueryHandler {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public FindUserByIdQueryHandler(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<UserDto> handle(FindUserByIdQuery query) {
        Optional<User> foundUser = userRepository.findById(query.id());
        return foundUser.map(user -> {
            UserDto userDto = mapper.mapTo(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}

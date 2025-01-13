package com.pr0f1t.taskcheck.queries.user.findByUsername;

import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FindUserByUsernameQueryHandler {
    private final UserRepository userRepository;
    private final Mapper<User, UserDto> mapper;

    public FindUserByUsernameQueryHandler(UserRepository userRepository, Mapper<User, UserDto> mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public ResponseEntity<UserDto> handle(FindUserByUsernameQuery query) {
        User user = userRepository.findByUsername(query.username()).orElse(null);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(mapper.mapTo(user), HttpStatus.OK);
    }
}

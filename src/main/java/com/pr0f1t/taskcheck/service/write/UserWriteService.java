package com.pr0f1t.taskcheck.service.write;

import com.pr0f1t.taskcheck.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserWriteService {

    User addUser(User user);

    User partialUpdateUser(User user);

    void deleteUserById(UUID id);

    boolean exists(UUID id);
}

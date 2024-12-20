package com.pr0f1t.TaskCheck.service.read;

import com.pr0f1t.TaskCheck.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface UserReadService {
    Optional<User> getUserById(UUID id);

    Optional<User> getUserByUsername(String username);

    List<User> getAllUsers();

    boolean exists(UUID id);

}

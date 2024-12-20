package com.pr0f1t.TaskCheck.service.read;

import com.pr0f1t.TaskCheck.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserReadService {
    Optional<User> getUserById(UUID id);

    Optional<User> getUserByUsername(String username);

    List<User> getAllUsers();

    boolean isExists(UUID id);

    boolean isExists(String username);
}

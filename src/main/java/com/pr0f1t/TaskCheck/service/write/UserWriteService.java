package com.pr0f1t.TaskCheck.service.write;

import com.pr0f1t.TaskCheck.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserWriteService {

    User addUser(User user);

    User updateUser(User user);

    void deleteUserById(UUID id);
}

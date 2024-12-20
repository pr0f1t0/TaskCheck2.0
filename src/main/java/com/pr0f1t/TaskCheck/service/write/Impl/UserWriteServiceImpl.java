package com.pr0f1t.TaskCheck.service.write.Impl;

import com.pr0f1t.TaskCheck.domain.entity.User;
import com.pr0f1t.TaskCheck.repository.UserRepository;
import com.pr0f1t.TaskCheck.service.write.UserWriteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserWriteServiceImpl implements UserWriteService {

    private final UserRepository userRepository;

    public UserWriteServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }
}

package com.pr0f1t.taskcheck.service.write.Impl;

import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.repository.UserRepository;
import com.pr0f1t.taskcheck.service.write.UserWriteService;
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
    public User partialUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean exists(UUID id) {
        return userRepository.existsById(id);
    }
}

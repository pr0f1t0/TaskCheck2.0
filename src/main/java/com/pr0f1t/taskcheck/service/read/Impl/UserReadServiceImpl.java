package com.pr0f1t.taskcheck.service.read.Impl;

import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.repository.UserRepository;
import com.pr0f1t.taskcheck.service.read.UserReadService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Component
public class UserReadServiceImpl implements UserReadService {

    private final UserRepository userRepository;

    public UserReadServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .toList();
    }


    @Override
    public boolean exists(UUID id) {
        return userRepository.existsById(id);
    }

}

package com.pr0f1t.TaskCheck.domain.repository;

import com.pr0f1t.TaskCheck.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}

package com.pr0f1t.taskcheck.common;

import com.pr0f1t.taskcheck.domain.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.UUID;

public class SecurityUtil {
    public static Optional<UUID> getCurrentUserId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .filter(User.class::isInstance)
                .map(User.class::cast)
                .map(User::getId);
    }
}

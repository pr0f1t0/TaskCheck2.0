package com.pr0f1t.taskcheck.queries.user.loggedInUserInfo;

import com.pr0f1t.taskcheck.domain.dto.UserInfoDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.queries.abstractions.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserInfoService implements Query<CurrentUserInfoQuery, UserInfoDto> {

    private final Mapper<User, UserInfoDto> mapper;

    public CurrentUserInfoService(Mapper<User, UserInfoDto> mapper) {
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<UserInfoDto> execute(CurrentUserInfoQuery query) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.status(HttpStatus.OK).body(mapper.mapTo(currentUser));
    }
}

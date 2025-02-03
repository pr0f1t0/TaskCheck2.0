package com.pr0f1t.taskcheck.mappers.Impl;

import com.pr0f1t.taskcheck.domain.dto.UserInfoDto;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserInfoMapper implements Mapper<User, UserInfoDto> {

    private final ModelMapper modelMapper;

    public UserInfoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserInfoDto mapTo(User user) {
        return modelMapper.map(user, UserInfoDto.class);
    }

    @Override
    public User mapFrom(UserInfoDto userInfoDto) {
        return modelMapper.map(userInfoDto, User.class);
    }
}

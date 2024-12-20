package com.pr0f1t.TaskCheck.mappers.Impl;

import com.pr0f1t.TaskCheck.domain.dto.UserDto;
import com.pr0f1t.TaskCheck.domain.entity.User;
import com.pr0f1t.TaskCheck.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements Mapper<User, UserDto> {

    private ModelMapper modelMapper;

    @Override
    public UserDto mapTo(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User mapFrom(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}

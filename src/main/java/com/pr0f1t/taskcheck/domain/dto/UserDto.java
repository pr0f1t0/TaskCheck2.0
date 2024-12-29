package com.pr0f1t.taskcheck.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    public String username;

    public String password;

    public String email;

    public List<TaskDto> tasks;

    public List<CategoryDto> categories;
}

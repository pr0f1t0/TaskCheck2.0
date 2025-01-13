package com.pr0f1t.taskcheck.domain.dto;

import com.pr0f1t.taskcheck.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    public String name;

    public User user;

    public List<TaskDto> tasks;

}

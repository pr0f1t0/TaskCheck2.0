package com.pr0f1t.TaskCheck.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    public UUID Id;

    public String Username;

    public String Password;

    public String Email;

    public List<TaskDto> Tasks;

    public List<CategoryDto> Categories;
}

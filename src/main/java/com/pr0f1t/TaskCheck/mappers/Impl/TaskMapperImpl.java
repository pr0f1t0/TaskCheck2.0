package com.pr0f1t.TaskCheck.mappers.Impl;

import com.pr0f1t.TaskCheck.domain.dto.TaskDto;
import com.pr0f1t.TaskCheck.domain.entity.Task;
import com.pr0f1t.TaskCheck.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class TaskMapperImpl implements Mapper<Task, TaskDto> {

    private ModelMapper modelMapper;


    @Override
    public TaskDto mapTo(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public Task mapFrom(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}

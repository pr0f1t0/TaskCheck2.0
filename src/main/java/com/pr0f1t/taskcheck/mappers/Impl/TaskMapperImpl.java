package com.pr0f1t.taskcheck.mappers.Impl;

import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements Mapper<Task, TaskDto> {

    private ModelMapper modelMapper;

    public TaskMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDto mapTo(Task task) {
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public Task mapFrom(TaskDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }
}

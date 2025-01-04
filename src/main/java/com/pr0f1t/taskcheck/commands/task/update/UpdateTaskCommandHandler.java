package com.pr0f1t.taskcheck.commands.task.update;

import com.pr0f1t.taskcheck.domain.dto.CategoryDto;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.dto.UserDto;
import com.pr0f1t.taskcheck.domain.entity.Category;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.domain.entity.User;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.util.UUID;

@Service
public class UpdateTaskCommandHandler {

    private final TaskRepository taskRepository;
    private final Mapper<Category, CategoryDto> categoryMapper;
    private final Mapper<User, UserDto> userMapper;
    private final Mapper<Task, TaskDto> taskMapper;


    public UpdateTaskCommandHandler(TaskRepository taskRepository,
                                    Mapper<Category, CategoryDto> categoryMapper,
                                    Mapper<User, UserDto> userMapper,
                                    Mapper<Task, TaskDto> taskMapper) {
        this.taskRepository = taskRepository;
        this.categoryMapper = categoryMapper;
        this.userMapper = userMapper;
        this.taskMapper = taskMapper;
    }

    public TaskDto handle(UpdateTaskCommand command, UUID id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        task.setTitle(command.title());
        task.setDescription(command.description());
        task.setDueDate(command.dueDate());
        task.setCompleted(command.completed());
        task.setImportant(command.important());
        task.setCategory(categoryMapper.mapFrom(command.category()));
        task.setUser(userMapper.mapFrom(command.user()));

        Task savedTask =  taskRepository.save(task);

        return taskMapper.mapTo(savedTask);
    }

}

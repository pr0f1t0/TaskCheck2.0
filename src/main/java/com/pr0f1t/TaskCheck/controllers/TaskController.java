package com.pr0f1t.TaskCheck.controllers;

import com.pr0f1t.TaskCheck.domain.dto.TaskDto;
import com.pr0f1t.TaskCheck.domain.entity.Task;
import com.pr0f1t.TaskCheck.mappers.Mapper;
import com.pr0f1t.TaskCheck.service.read.TaskReadService;
import com.pr0f1t.TaskCheck.service.write.TaskWriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TaskController {

    private final TaskReadService taskReadService;
    private final TaskWriteService taskWriteService;
    private final Mapper<Task, TaskDto> taskMapper;

    public TaskController(TaskReadService taskReadService, TaskWriteService taskWriteService, Mapper<Task, TaskDto> taskMapper) {
        this.taskReadService = taskReadService;
        this.taskWriteService = taskWriteService;
        this.taskMapper = taskMapper;
    }

    @GetMapping(path = "/tasks/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable UUID id) {
        Optional<Task> foundTask = taskReadService.getTaskById(id);
        return foundTask.map(task ->{
            TaskDto taskDto = taskMapper.mapTo(task);
            return new ResponseEntity<>(taskDto, HttpStatus.OK);
        } ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/tasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = taskReadService.getAllTasks();
        return tasks.stream().map(taskMapper::mapTo).toList();
    }


    @PostMapping(path = "/tasks")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task taskEntity = taskMapper.mapFrom(taskDto);
        Task savedTaskEntity = taskWriteService.addTask(taskEntity);
        return taskMapper.mapTo(savedTaskEntity);
    }


    @PatchMapping(path = "/tasks/{id}")
    public ResponseEntity<TaskDto> partialUpdateTask(@PathVariable UUID id, @RequestBody TaskDto taskDto) {
        Task updates = taskMapper.mapFrom(taskDto);

        if (!taskWriteService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Task updatedTask = taskWriteService.partialUpdateTask(id, updates);

        return new ResponseEntity<>(taskMapper.mapTo(updatedTask), HttpStatus.OK);
    }

    @DeleteMapping(path = "/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
        if (!taskWriteService.exists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskWriteService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.commands.task.add.AddTaskCommand;
import com.pr0f1t.taskcheck.commands.task.add.AddTaskService;
import com.pr0f1t.taskcheck.commands.task.delete.DeleteTaskCommand;
import com.pr0f1t.taskcheck.commands.task.delete.DeleteTaskService;
import com.pr0f1t.taskcheck.commands.task.update.UpdateTaskCommand;
import com.pr0f1t.taskcheck.commands.task.update.UpdateTaskService;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class TaskController {

    private final AddTaskService addTaskService;
    private final DeleteTaskService deleteTaskService;
    private final UpdateTaskService updateTaskService;

    public TaskController(AddTaskService addTaskService, DeleteTaskService deleteTaskService, UpdateTaskService updateTaskService) {
        this.addTaskService = addTaskService;
        this.deleteTaskService = deleteTaskService;
        this.updateTaskService = updateTaskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> addTask(@RequestBody AddTaskCommand command) {
        return addTaskService.execute(command);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID id) {
       return deleteTaskService.execute(new DeleteTaskCommand(id));
    }

    @PatchMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto,
                                              @PathVariable UUID id) {
        return updateTaskService.execute(new UpdateTaskCommand(taskDto, id));
    }
}

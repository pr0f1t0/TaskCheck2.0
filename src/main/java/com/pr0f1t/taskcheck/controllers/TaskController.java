package com.pr0f1t.taskcheck.controllers;

import com.pr0f1t.taskcheck.commands.task.add.AddTaskCommand;
import com.pr0f1t.taskcheck.commands.task.add.AddTaskService;
import com.pr0f1t.taskcheck.commands.task.delete.DeleteTaskCommand;
import com.pr0f1t.taskcheck.commands.task.delete.DeleteTaskService;
import com.pr0f1t.taskcheck.commands.task.update.UpdateTaskCommand;
import com.pr0f1t.taskcheck.commands.task.update.UpdateTaskService;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.queries.task.getTasksByCategoryId.GetTasksByCategoryIdQuery;
import com.pr0f1t.taskcheck.queries.task.getTasksByCategoryId.GetTasksByCategoryIdService;
import com.pr0f1t.taskcheck.queries.task.getTasksByUserId.GetTasksByUserIdQuery;
import com.pr0f1t.taskcheck.queries.task.getTasksByUserId.GetTasksByUserIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {

    private final AddTaskService addTaskService;
    private final DeleteTaskService deleteTaskService;
    private final UpdateTaskService updateTaskService;
    private final GetTasksByUserIdService getTasksByUserIdService;
    private final GetTasksByCategoryIdService getTasksByCategoryIdService;

    public TaskController(AddTaskService addTaskService, DeleteTaskService deleteTaskService,
                          UpdateTaskService updateTaskService, GetTasksByUserIdService getTasksByUserIdService,
                          GetTasksByCategoryIdService getTasksByCategoryIdService) {
        this.addTaskService = addTaskService;
        this.deleteTaskService = deleteTaskService;
        this.updateTaskService = updateTaskService;
        this.getTasksByUserIdService = getTasksByUserIdService;
        this.getTasksByCategoryIdService = getTasksByCategoryIdService;
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

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return getTasksByUserIdService.execute(new GetTasksByUserIdQuery());
    }

    @GetMapping("/tasks/category/{id}")
    public ResponseEntity<List<TaskDto>> getTasksByCategory(@PathVariable UUID id) {
        return getTasksByCategoryIdService.execute(new GetTasksByCategoryIdQuery(id));
    }
}

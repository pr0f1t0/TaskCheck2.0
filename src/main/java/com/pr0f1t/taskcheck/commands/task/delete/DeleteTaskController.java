package com.pr0f1t.taskcheck.commands.task.delete;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteTaskController {
    private final DeleteTaskCommandHandler deleteTaskCommandHandler;

    public DeleteTaskController(DeleteTaskCommandHandler deleteTaskCommandHandler) {
        this.deleteTaskCommandHandler = deleteTaskCommandHandler;
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable UUID id) {
        DeleteTaskCommand deleteTaskCommand = new DeleteTaskCommand(id);
        deleteTaskCommandHandler.handle(deleteTaskCommand);
    }

}

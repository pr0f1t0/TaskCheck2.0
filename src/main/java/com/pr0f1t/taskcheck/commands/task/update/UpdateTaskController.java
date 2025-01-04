package com.pr0f1t.taskcheck.commands.task.update;

import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UpdateTaskController {
    private final UpdateTaskCommandHandler updateTaskCommandHandler;

    public UpdateTaskController(UpdateTaskCommandHandler updateTaskCommandHandler) {
        this.updateTaskCommandHandler = updateTaskCommandHandler;
    }

    @PatchMapping("/tasks/{id}")
    public TaskDto updateTask(@RequestBody UpdateTaskCommand updateTaskCommand, @PathVariable UUID id) {
        return updateTaskCommandHandler.handle(updateTaskCommand, id);
    }
}

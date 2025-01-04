package com.pr0f1t.taskcheck.commands.task.add;

import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddTaskController {

    private final AddTaskCommandHandler addTaskCommandHandler;

    public AddTaskController(AddTaskCommandHandler addTaskCommandHandler) {
        this.addTaskCommandHandler = addTaskCommandHandler;
    }

    @PostMapping("/tasks")
    public TaskDto addTask(@RequestBody AddTaskCommand command) {
        return addTaskCommandHandler.handle(command);
    }
}

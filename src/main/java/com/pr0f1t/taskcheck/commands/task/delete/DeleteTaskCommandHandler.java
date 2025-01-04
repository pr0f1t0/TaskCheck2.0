package com.pr0f1t.taskcheck.commands.task.delete;

import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskCommandHandler {
    private final TaskRepository taskRepository;

    public DeleteTaskCommandHandler(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<Void> handle(DeleteTaskCommand command){
        if(!taskRepository.existsById(command.id())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        taskRepository.deleteById(command.id());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

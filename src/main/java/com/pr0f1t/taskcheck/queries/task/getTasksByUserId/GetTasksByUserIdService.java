package com.pr0f1t.taskcheck.queries.task.getTasksByUserId;

import com.pr0f1t.taskcheck.common.SecurityUtil;
import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.exceptions.errorMessages.UserErrorMessages;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.queries.abstractions.Query;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetTasksByUserIdService implements Query<GetTasksByUserIdQuery, List<TaskDto>> {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;

    public GetTasksByUserIdService(TaskRepository taskRepository,
                                   Mapper<Task, TaskDto> mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<List<TaskDto>> execute(GetTasksByUserIdQuery query) {

        UUID userId = SecurityUtil.getCurrentUserId()
                .orElseThrow(() -> new SignatureException(UserErrorMessages.USER_NOT_AUTHENTICATED.getMessage()));

        List<Task> tasks = taskRepository.findByUserId(userId);
        List<TaskDto> taskDtos = tasks.stream().map(mapper::mapTo).toList();
        return ResponseEntity.status(HttpStatus.OK).body(taskDtos);
    }
}

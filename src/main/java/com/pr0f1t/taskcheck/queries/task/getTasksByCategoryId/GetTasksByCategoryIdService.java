package com.pr0f1t.taskcheck.queries.task.getTasksByCategoryId;

import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import com.pr0f1t.taskcheck.domain.entity.Task;
import com.pr0f1t.taskcheck.mappers.Mapper;
import com.pr0f1t.taskcheck.queries.abstractions.Query;
import com.pr0f1t.taskcheck.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTasksByCategoryIdService implements Query<GetTasksByCategoryIdQuery, List<TaskDto>> {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDto> mapper;

    public GetTasksByCategoryIdService(TaskRepository taskRepository, Mapper<Task, TaskDto> mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<List<TaskDto>> execute(GetTasksByCategoryIdQuery query) {

        List<Task> tasks = taskRepository.findByCategoryId(query.getCategoryId());

        List<TaskDto> taskDtos = tasks.stream().map(mapper::mapTo).toList();
        return ResponseEntity.status(HttpStatus.OK).body(taskDtos);
    }
}

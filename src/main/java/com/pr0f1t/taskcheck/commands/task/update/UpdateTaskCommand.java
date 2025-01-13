package com.pr0f1t.taskcheck.commands.task.update;


import com.pr0f1t.taskcheck.domain.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTaskCommand{
        private TaskDto taskDto;
        private UUID id;
}

package com.pr0f1t.taskcheck.commands.task.add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddTaskCommand{

        private String title;

        private String description;

        private LocalDateTime dueDate;

        private boolean important;

        private UUID categoryId;


}

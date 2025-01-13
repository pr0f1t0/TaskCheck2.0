package com.pr0f1t.taskcheck.commands.task.delete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeleteTaskCommand{
    UUID id;
}

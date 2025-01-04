package com.pr0f1t.taskcheck.commands.category.add;

import com.pr0f1t.taskcheck.domain.entity.User;

public record AddCategoryCommand(
    String name,
    User user
) {}

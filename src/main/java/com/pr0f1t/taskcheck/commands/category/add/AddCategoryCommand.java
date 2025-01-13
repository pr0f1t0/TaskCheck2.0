package com.pr0f1t.taskcheck.commands.category.add;

import com.pr0f1t.taskcheck.domain.entity.User;
import lombok.Getter;

@Getter
public class AddCategoryCommand{
    private String name;
    private User user;
}



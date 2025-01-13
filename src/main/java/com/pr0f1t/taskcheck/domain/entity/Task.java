package com.pr0f1t.taskcheck.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String title;

    public String description;

    public LocalDateTime createdAt;

    public LocalDateTime dueDate;

    public boolean completed;

    public boolean important;

    @ManyToOne(targetEntity = Category.class, optional = true)
    @JoinColumn(name = "category_id")
    public Category category;

    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "user_id")
    public User user;

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}

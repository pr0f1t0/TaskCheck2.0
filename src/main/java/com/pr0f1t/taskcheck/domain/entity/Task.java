package com.pr0f1t.taskcheck.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Setter
    public String title;

    @Setter
    public String description;

    public LocalDateTime createdAt;

    @Setter
    public LocalDateTime dueDate;

    @Setter
    public boolean completed;

    @Setter
    public boolean important;

    @Setter
    @ManyToOne(targetEntity = Category.class, optional = true)
    @JoinColumn(name = "category_id")
    public Category category;

    @Setter
    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "user_id")
    public User user;

    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}

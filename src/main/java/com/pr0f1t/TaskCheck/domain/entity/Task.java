package com.pr0f1t.TaskCheck.domain.entity;

import com.fasterxml.jackson.datatype.jsr310.deser.key.LocalDateTimeKeyDeserializer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tasks")
public class Task {
    @Id
    public UUID Id;

    public String Title;

    public String Description;

    public LocalDateTime CreatedAt;

    public LocalDateTime DueDate;

    public boolean IsCompleted;

    public boolean IsImportant;

    @ManyToOne(targetEntity = Category.class, optional = true)
    public Category Category;

    @ManyToOne(targetEntity = User.class, optional = false)
    public User User;
}

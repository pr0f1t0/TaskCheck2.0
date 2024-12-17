package com.pr0f1t.TaskCheck.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "categories")
public class Category {
    @Id
    public UUID Id;

    public String Name;

    @OneToMany(mappedBy = "Category", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Task> Tasks;
}

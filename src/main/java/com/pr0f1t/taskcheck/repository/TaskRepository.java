package com.pr0f1t.taskcheck.repository;

import com.pr0f1t.taskcheck.domain.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID>,
        PagingAndSortingRepository<Task, UUID> {
    List<Task> findByUserId(UUID userId);
    Page<Task> findByUserId(UUID userId, Pageable pageable);

    List<Task> findByCategoryId(UUID categoryId);
    Page<Task> findByCategoryId(UUID categoryId, Pageable pageable);
}

package com.practice.trello.repo;

import com.practice.trello.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskListRepo extends JpaRepository<TaskList, Integer> {
}

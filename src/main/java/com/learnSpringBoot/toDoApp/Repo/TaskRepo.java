package com.learnSpringBoot.toDoApp.Repo;

import com.learnSpringBoot.toDoApp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

}

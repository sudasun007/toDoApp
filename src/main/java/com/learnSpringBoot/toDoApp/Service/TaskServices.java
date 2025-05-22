package com.learnSpringBoot.toDoApp.Service;

import com.learnSpringBoot.toDoApp.Model.Task;
import com.learnSpringBoot.toDoApp.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {
    @Autowired
    private final TaskRepo taskRepo;


    public TaskServices(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task Id:" + id));
        task.setCompleted(!task.isCompleted());
        taskRepo.save(task);

    }
}

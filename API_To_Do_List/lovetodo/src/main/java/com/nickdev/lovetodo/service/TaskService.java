package com.nickdev.lovetodo.service;

import com.nickdev.lovetodo.model.Task;
import com.nickdev.lovetodo.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository tr;

    public TaskService(TaskRepository tr) {
        this.tr = tr;
    }

    public Task createTask(Task task){
        log.info("Creating task");
        if (task == null || task.getTitle().isEmpty()){
            throw new RuntimeException("task title is required");
        }else {
            log.info("Created task");
            Task newTask = tr.save(task);
            return newTask;
        }
    }

    public List<Task> findAll(){
        log.info("Finding all tasks");
        if (tr.findAll() == null){
            throw new RuntimeException("no tasks found");
        }else{
            log.info("Found all tasks");
            return tr.findAll();
        }
    }

    public Task findById(long id){
        log.info("Finding task by id");
        return tr.findById(id)
                .orElseThrow();
    }

    public void deleteById(long id){
        log.info("Deleting task by id");
        tr.deleteById(id);
    }

    public Task updateTask(Long id, Task newTask){
        log.info("Updating task");
        Task existingTask = findById(id);

        existingTask.setTitle(newTask.getTitle());
        existingTask.setDescription(newTask.getDescription());
        existingTask.setCreationDate(newTask.getCreationDate());
        existingTask.setStatus(newTask.getStatus());

        log.info("Updated task");
        return tr.save(newTask);

    }

}

package com.nickdev.lovetodo.repository;

import com.nickdev.lovetodo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>{

}

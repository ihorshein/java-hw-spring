package com.ihorshein.java_hw_spring.repository;

import com.ihorshein.java_hw_spring.model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {

  List<TaskHistory> findByTodoId(Long todoId);
}

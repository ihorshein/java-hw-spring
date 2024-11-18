package com.ihorshein.java_hw_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task_history")
public class TaskHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "todo_id", referencedColumnName = "id")
  Todo todo;

  @Column(name = "old_state")
  String oldState;

  @Column(name = "new_state")
  String newState;

  @CreationTimestamp
  @Column(name = "change_date", nullable = false)
  LocalDateTime changeDate;

  @Column(name = "changed_by")
  String changedBy = null;

  // Lombok failed for those setters.

  public void setTodo(Todo todo) {
    this.todo = todo;
  }

  public void setOldState(String oldState) {
    this.oldState = oldState;
  }

  public void setNewState(String newState) {
    this.newState = newState;
  }
}
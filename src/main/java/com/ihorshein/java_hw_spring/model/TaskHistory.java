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
  private Long id;

  @ManyToOne
  @JoinColumn(name = "todo_id", referencedColumnName = "id")
  private Todo todo;

  @Column(name = "old_state")
  private String oldState;

  @Column(name = "new_state")
  private String newState;

  @CreationTimestamp
  @Column(name = "change_date", nullable = false)
  private LocalDateTime changeDate;

  @Column(name = "changed_by")
  private String changedBy = null;
}

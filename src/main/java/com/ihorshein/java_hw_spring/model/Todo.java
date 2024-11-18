package com.ihorshein.java_hw_spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todo")
@SQLDelete(sql = "UPDATE todo SET is_delete = TRUE WHERE id = ?")
@SQLRestriction("is_delete = false")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(length = 100, nullable = false)
  String title;

  @Column(length = 500)
  String description;

  @Column(name = "due_date", nullable = false)
  LocalDateTime dueDate;

  @Column(length = 45)
  @Enumerated(EnumType.STRING)
  TodoPriority priority;

  @Column(length = 45)
  @Enumerated(EnumType.STRING)
  TodoStatus status;

  @CreationTimestamp
  @Column(name = "created_date", nullable = false)
  LocalDateTime createdDate;

  @UpdateTimestamp
  @Column(name = "updated_date", nullable = false)
  LocalDateTime updatedDate;

  @Column(name = "user_id", nullable = false)
  Long userId = 1L;

  @Column(name = "is_delete", nullable = false)
  boolean isDelete = false;
}
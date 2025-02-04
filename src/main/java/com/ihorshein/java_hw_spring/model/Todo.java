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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todo")
@SQLDelete(sql = "UPDATE todo SET is_delete = TRUE WHERE id = ?")
@SQLRestriction("is_delete = false")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String title;

  @Column(length = 500)
  private String description;

  @Column(name = "due_date", nullable = false)
  private LocalDateTime dueDate;

  @Column(length = 45)
  @Enumerated(EnumType.STRING)
  private TodoPriority priority;

  @Column(length = 45)
  @Enumerated(EnumType.STRING)
  private TodoStatus status;

  @CreationTimestamp
  @Column(name = "created_date", nullable = false)
  private LocalDateTime createdDate;

  @UpdateTimestamp
  @Column(name = "updated_date", nullable = false)
  private LocalDateTime updatedDate;

  @Column(name = "user_id", nullable = false)
  private Long userId = 1L;

  @Column(name = "is_delete", nullable = false)
  private boolean isDelete = false;
}

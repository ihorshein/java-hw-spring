package com.ihorshein.java_hw_spring.dto;

import com.ihorshein.java_hw_spring.model.TodoPriority;
import com.ihorshein.java_hw_spring.model.TodoStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {

  private Long id;

  private String title;

  private String description;

  private LocalDateTime dueDate;

  private TodoPriority priority;

  private TodoStatus status;

  private LocalDateTime createdDate;

  private LocalDateTime updatedDate;

  private Long userId;
}

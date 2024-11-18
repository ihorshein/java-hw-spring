package com.ihorshein.java_hw_spring.dto;

import com.ihorshein.java_hw_spring.model.TodoPriority;
import com.ihorshein.java_hw_spring.model.TodoStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TodoResponseDto {

  Long id;

  String title;

  String description;

  LocalDateTime dueDate;

  TodoPriority priority;

  TodoStatus status;

  LocalDateTime createdDate;

  LocalDateTime updatedDate;

  Long userId;
}

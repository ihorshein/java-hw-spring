package com.ihorshein.java_hw_spring.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskHistoryResponseDto {

  private Long id;

  private Long todoId;

  private String oldState;

  private String newState;

  private LocalDateTime changeDate;

  private String changedBy;
}

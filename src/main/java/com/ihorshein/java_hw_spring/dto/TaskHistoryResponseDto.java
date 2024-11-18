package com.ihorshein.java_hw_spring.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskHistoryResponseDto {

  Long id;

  Long todoId;

  String oldState;

  String newState;

  LocalDateTime changeDate;

  String changedBy;
}

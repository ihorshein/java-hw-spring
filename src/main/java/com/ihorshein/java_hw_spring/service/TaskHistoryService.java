package com.ihorshein.java_hw_spring.service;

import com.ihorshein.java_hw_spring.dto.TaskHistoryResponseDto;

import java.util.List;

public interface TaskHistoryService {

  List<TaskHistoryResponseDto> history(Long todoId);
}

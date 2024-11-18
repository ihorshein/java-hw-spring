package com.ihorshein.java_hw_spring.service.impl;

import com.ihorshein.java_hw_spring.dto.TaskHistoryResponseDto;
import com.ihorshein.java_hw_spring.model.TaskHistory;
import com.ihorshein.java_hw_spring.repository.TaskHistoryRepository;
import com.ihorshein.java_hw_spring.service.TaskHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {

  private final TaskHistoryRepository taskHistoryRepository;

  private final ModelMapper modelMapper = new ModelMapper();

  public TaskHistoryServiceImpl(TaskHistoryRepository taskHistoryRepository) {
    this.taskHistoryRepository = taskHistoryRepository;
  }

  @Override
  public List<TaskHistoryResponseDto> history(Long todoId) {
    List<TaskHistory> taskHistoryList = taskHistoryRepository.findByTodoId(todoId);

    modelMapper.typeMap(TaskHistory.class, TaskHistoryResponseDto.class)
      .addMappings(mapper -> {
        mapper.map(src -> src.getTodo().getId(), TaskHistoryResponseDto::setTodoId);
      });

    return taskHistoryList.stream()
      .map(taskHistory -> modelMapper.map(taskHistory, TaskHistoryResponseDto.class))
      .toList();
  }
}

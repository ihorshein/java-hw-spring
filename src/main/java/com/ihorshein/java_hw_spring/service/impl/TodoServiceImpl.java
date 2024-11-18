package com.ihorshein.java_hw_spring.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ihorshein.java_hw_spring.model.TaskHistory;
import com.ihorshein.java_hw_spring.model.Todo;
import com.ihorshein.java_hw_spring.dto.TodoCreateDto;
import com.ihorshein.java_hw_spring.dto.TodoResponseDto;
import com.ihorshein.java_hw_spring.dto.TodoUpdateDto;
import com.ihorshein.java_hw_spring.repository.TaskHistoryRepository;
import com.ihorshein.java_hw_spring.repository.TodoRepository;
import com.ihorshein.java_hw_spring.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoServiceImpl implements TodoService {

  private final TodoRepository todoRepository;
  private final TaskHistoryRepository taskHistoryRepository;

  private final ModelMapper modelMapper = new ModelMapper();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public TodoServiceImpl(TodoRepository todoRepository, TaskHistoryRepository taskHistoryRepository) {
    this.todoRepository = todoRepository;
    this.taskHistoryRepository = taskHistoryRepository;

    objectMapper.registerModule(new JavaTimeModule());
  }

  @Override
  public TodoResponseDto create(TodoCreateDto todoCreateDto) {
    Todo todo = modelMapper.map(todoCreateDto, Todo.class);

    todo = todoRepository.save(todo);

    return modelMapper.map(todo, TodoResponseDto.class);
  }

  @Override
  @Transactional
  public TodoResponseDto update(Long id, TodoUpdateDto todoUpdateDto) {
    Todo todo = todoRepository.findById(id).orElseThrow();

    String oldState;
    String newState;

    try {
      oldState = objectMapper.writeValueAsString(todo);

      modelMapper.map(todoUpdateDto, todo);

      newState = objectMapper.writeValueAsString(todo);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    todo = todoRepository.save(todo);

    TaskHistory taskHistory = new TaskHistory();
    taskHistory.setTodo(todo);
    taskHistory.setOldState(oldState);
    taskHistory.setNewState(newState);

    taskHistoryRepository.save(taskHistory);

    return modelMapper.map(todo, TodoResponseDto.class);
  }

  @Override
  public void delete(Long id) {
    todoRepository.deleteById(id);
  }
}

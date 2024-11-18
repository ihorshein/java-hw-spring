package com.ihorshein.java_hw_spring.service;

import com.ihorshein.java_hw_spring.dto.TodoCreateDto;
import com.ihorshein.java_hw_spring.dto.TodoResponseDto;
import com.ihorshein.java_hw_spring.dto.TodoUpdateDto;

public interface TodoService {

  TodoResponseDto create(TodoCreateDto todoCreateDto);

  TodoResponseDto update(Long id, TodoUpdateDto todoUpdateDto);

  void delete(Long id);
}

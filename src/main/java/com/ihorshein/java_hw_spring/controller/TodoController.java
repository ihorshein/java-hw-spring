package com.ihorshein.java_hw_spring.controller;

import com.ihorshein.java_hw_spring.dto.TaskHistoryResponseDto;
import com.ihorshein.java_hw_spring.dto.TodoCreateDto;
import com.ihorshein.java_hw_spring.dto.TodoResponseDto;
import com.ihorshein.java_hw_spring.dto.TodoUpdateDto;
import com.ihorshein.java_hw_spring.service.TaskHistoryService;
import com.ihorshein.java_hw_spring.service.TodoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

  private final TodoService todoService;
  private final TaskHistoryService taskHistoryService;

  public TodoController(TodoService todoService, TaskHistoryService taskHistoryService) {
    this.todoService = todoService;
    this.taskHistoryService = taskHistoryService;
  }

  @PostMapping
  public TodoResponseDto create(@RequestBody @Valid TodoCreateDto todoCreateDto) {
    return todoService.create(todoCreateDto);
  }

  @PutMapping("/{todoId}")
  public TodoResponseDto update(@PathVariable Long todoId, @RequestBody @Valid TodoUpdateDto todoUpdateDto) {
    return todoService.update(todoId, todoUpdateDto);
  }

  @DeleteMapping("/{todoId}")
  public void delete(@PathVariable Long todoId) {
    todoService.delete(todoId);
  }

  @GetMapping("/{todoId}/history")
  public List<TaskHistoryResponseDto> view(@PathVariable Long todoId) {
    return taskHistoryService.history(todoId);
  }
}

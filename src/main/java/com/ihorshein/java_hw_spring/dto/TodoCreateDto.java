package com.ihorshein.java_hw_spring.dto;

import com.ihorshein.java_hw_spring.model.TodoPriority;
import com.ihorshein.java_hw_spring.validation.EnumValue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class TodoCreateDto {

  @NotBlank(message = "Name cannot be empty")
  @Length(min = 3, max = 100, message = "Maximum length exceeded")
  private String title;

  @Length(max = 500, message = "Maximum length exceeded")
  private String description;

  @NotNull(message = "Due date cannot be empty")
  @FutureOrPresent(message = "The date can be today or in the future")
  private LocalDateTime dueDate;

  @Length(max = 45, message = "Maximum length exceeded")
  @EnumValue(enumClass = TodoPriority.class, message = "Invalid priority")
  private String priority;
}

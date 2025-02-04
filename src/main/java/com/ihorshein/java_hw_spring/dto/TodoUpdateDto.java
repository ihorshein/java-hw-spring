package com.ihorshein.java_hw_spring.dto;

import com.ihorshein.java_hw_spring.model.TodoStatus;
import com.ihorshein.java_hw_spring.validation.EnumValue;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Data
@EqualsAndHashCode(callSuper = true)
public class TodoUpdateDto extends TodoCreateDto {

  @NotBlank(message = "Status must be set")
  @Length(max = 45, message = "Maximum length exceeded")
  @EnumValue(enumClass = TodoStatus.class, message = "Invalid status")
  private String status;
}

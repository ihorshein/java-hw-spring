package com.ihorshein.java_hw_spring.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<EnumValue, String> {

  private Enum<?>[] enumConstants;

  @Override
  public void initialize(EnumValue constraintAnnotation) {
    enumConstants = constraintAnnotation.enumClass().getEnumConstants();
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
    if (name == null || name.isBlank()) {
      return true;
    }

    if (enumConstants == null) {
      return false;
    }

    for (Enum<?> id : enumConstants) {
      if (id.name().equals(name)) {
        return true;
      }
    }

    return false;
  }
}

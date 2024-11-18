package com.ihorshein.java_hw_spring.config;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private record ErrorResponse(LocalDateTime time, HttpStatus status, List<String> error) {
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatusCode status,
    WebRequest request
  ) {
    List<String> errors = ex.getBindingResult().getFieldErrors().stream()
      .sorted(Comparator.comparing(FieldError::getField))
      .map(fieldError -> String.format("Field '%s': %s", fieldError.getField(), fieldError.getDefaultMessage()))
      .toList();

    ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST, errors);

    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(errorResponse);
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
    return getStandartTemplateOfResponseEntity(ex, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ErrorResponse> handleSQLException(SQLException ex) {
    return getStandartTemplateOfResponseEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ErrorResponse> getStandartTemplateOfResponseEntity(Throwable e, HttpStatus httpStatus) {
    ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), httpStatus, List.of(e.getMessage()));

    return ResponseEntity.status(httpStatus).body(errorResponse);
  }
}


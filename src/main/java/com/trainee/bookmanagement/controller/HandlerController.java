package com.trainee.bookmanagement.controller;

import com.trainee.bookmanagement.NotFoundException;
import com.trainee.bookmanagement.Response;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerController {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Response handlerValidationException(MethodArgumentNotValidException exception) {
    Map<String, String> map = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error) ->{
      String fieldName = ((FieldError)error).getField();
      String errorMessage = error.getDefaultMessage();
      map.put(fieldName, errorMessage);
    });
    return new Response(HttpStatus.BAD_REQUEST, "Validation error", map);
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public Response handlerNotFoundException(NotFoundException exception) {
    return new Response(HttpStatus.NOT_FOUND, "Not Found", exception.getMessage());
  }
}

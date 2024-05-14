package com.trainee.bookmanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response extends ResponseEntity<Map<String, Object>> {

  private final HttpStatus status;

  private final String message;

  private final Object data;

  public Response (HttpStatus status, String message, Object data) {
    super(status);

    this.status = status;
    this.message = message;
    this.data = data;
  }

  @Override
  public Map<String, Object> getBody() {
    Map<String, Object> map = new HashMap<>();

    map.put("status", status.value());
    map.put("message", message);
    map.put("data", data);
    return map;
  }
}

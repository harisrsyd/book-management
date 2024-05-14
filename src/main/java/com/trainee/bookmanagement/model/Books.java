package com.trainee.bookmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Entity
@Getter
@Setter
public class Books {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Title is required")
  private String title;

  //@NotBlank(message = "Publish Year is required")
  private Year publishYear;

  @NotBlank(message = "Author is required")
  private String author;

  @NotBlank(message = "Publisher is required")
  private String publisher;

  @NotBlank(message = "ISBN is required")
  private String isbn;

  private String language;

  private Long pages;
}

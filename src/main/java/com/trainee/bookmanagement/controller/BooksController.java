package com.trainee.bookmanagement.controller;

import com.trainee.bookmanagement.NotFoundException;
import com.trainee.bookmanagement.Response;
import com.trainee.bookmanagement.model.Books;
import com.trainee.bookmanagement.service.BooksService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

  @Autowired
  private BooksService booksService;

  @GetMapping("")
  public Response getAll(@RequestParam(value = "search", required = false) String keyword) {
    if (keyword != null) {
      return new Response(HttpStatus.OK, "Search books success", booksService.search(keyword));
    } else {
      return new Response(HttpStatus.OK, "Books list success", booksService.list());
    }
  }

  @GetMapping("/{id}")
  public Response getDetail(@PathVariable Long id) throws NotFoundException {
    return new Response(HttpStatus.OK, "Get Detail Book success", booksService.detail(id));
  }

  @PostMapping("")
  public Response create(@Valid @RequestBody Books books) {
    booksService.create(books);
    return new Response(HttpStatus.CREATED, "Create Book success", books);
  }

  @PutMapping("/{id}")
  public Response update(@PathVariable Long id, @Valid @RequestBody Books books) throws NotFoundException {
    booksService.update(id, books);
    return new Response(HttpStatus.ACCEPTED, "Update Book success", books);
  }

  @DeleteMapping("/{id}")
  public Response delete(@PathVariable Long id) throws NotFoundException {
    booksService.delete(id);
    return new Response(HttpStatus.OK, "Delete Book success", null);
  }
}

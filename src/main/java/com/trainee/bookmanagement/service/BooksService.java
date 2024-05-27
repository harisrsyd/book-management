package com.trainee.bookmanagement.service;

import com.trainee.bookmanagement.NotFoundException;
import com.trainee.bookmanagement.model.Books;
import com.trainee.bookmanagement.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
  private final BooksRepository booksRepository;

  public BooksService(BooksRepository booksRepository) {
    this.booksRepository = booksRepository;
  }

  public List<Books> list() {
    return booksRepository.findAll();
  }

  public List<Books> search(String keyword) {
    return booksRepository.findByTitleContainingIgnoreCase(keyword);
  }

  public Books detail(Long id) throws NotFoundException {
    return booksRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Book Not Found"));
  }

  public void create(Books books) {
    booksRepository.save(books);
  }

  public Books update(Long id, Books books) throws NotFoundException {
    Books book = booksRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Book Not Found"));

    book.setTitle(books.getTitle());
    book.setAuthor(books.getAuthor());
    book.setPublishYear(books.getPublishYear());
    book.setPublisher(book.getPublisher());
    book.setIsbn(books.getIsbn());
    book.setLanguage(books.getLanguage());
    book.setPages(books.getPages());
    return booksRepository.save(book);
  }

  public void delete(Long id) throws NotFoundException {
    Books books = booksRepository.findById(id)
            .orElseThrow(()->new NotFoundException("Book Not Found"));

    booksRepository.delete(books);
  }
}

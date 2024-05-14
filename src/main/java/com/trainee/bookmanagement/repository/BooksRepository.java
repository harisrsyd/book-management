package com.trainee.bookmanagement.repository;

import com.trainee.bookmanagement.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

  List<Books> findByTitleContainingIgnoreCase(String keyword);
}

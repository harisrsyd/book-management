package com.trainee.bookmanagement.model;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {
    Books books = new Books();

    @Test
    void testNotNullBook() {
        assertNotNull(books);
    }

    @Test
    void testGettersAndSetters() {
        books.setId(1L);
        books.setTitle("Title");
        books.setPublishYear(Year.of(2024));
        books.setAuthor("Author");
        books.setPublisher("Publisher");
        books.setIsbn("ISBN");
        books.setLanguage("Language");
        books.setPages(100L);

        assertEquals(1L, books.getId());
        assertEquals("Title", books.getTitle());
        assertEquals(Year.of(2024), books.getPublishYear());
        assertEquals("Author", books.getAuthor());
        assertEquals("Publisher", books.getPublisher());
        assertEquals("ISBN", books.getIsbn());
        assertEquals("Language", books.getLanguage());
        assertEquals(100L, books.getPages());
    }
}
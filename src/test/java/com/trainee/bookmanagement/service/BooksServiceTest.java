package com.trainee.bookmanagement.service;

import com.trainee.bookmanagement.NotFoundException;
import com.trainee.bookmanagement.model.Books;
import com.trainee.bookmanagement.repository.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BooksServiceTest {
    BooksService booksService;

    @Mock
    BooksRepository booksRepository;

    @BeforeEach
    void setUp() {
        booksService = new BooksService(booksRepository);
    }

    @Test
    void testNotNull() {
        assertNotNull(booksService);
        assertNotNull(booksRepository);
    }

    @Test
    void testList() {
        when(booksRepository.findAll()).thenReturn(List.of(new Books()));
        assertEquals(1, booksService.list().size());
    }

    @Test
    void testSearch() {
        when(booksRepository.findByTitleContainingIgnoreCase("title")).thenReturn(List.of(new Books()));
        assertEquals(1, booksService.search("title").size());
    }

    @Test
    void testDetail() throws NotFoundException {
        when(booksRepository.findById(1L)).thenReturn(java.util.Optional.of(new Books()));
        assertNotNull(booksService.detail(1L));
    }

    @Test
    void testCreate() {
        Books books = new Books();
        booksService.create(books);
        verify(booksRepository, times(1)).save(books);
    }

    @Test
    void testUpdate() throws NotFoundException {
        Books books = new Books();
        when(booksRepository.findById(1L)).thenReturn(java.util.Optional.of(books));
        booksService.update(1L, books);
        verify(booksRepository, times(1)).save(books);
    }

    @Test
    void testDelete() throws NotFoundException {
        Books books = new Books();
        when(booksRepository.findById(1L)).thenReturn(java.util.Optional.of(books));
        booksService.delete(1L);
        verify(booksRepository, times(1)).delete(books);
    }
}
package com.example.libraryapi.service;

import com.example.libraryapi.dto.BookCreateRequest;
import com.example.libraryapi.dto.BookResponse;
import com.example.libraryapi.dto.BookUpdateRequest;

import java.util.List;

public interface BookService {
    BookResponse create(BookCreateRequest req);
    List<BookResponse> getAll();
    BookResponse getById(Long id);
    BookResponse update(Long id, BookUpdateRequest req);
    void delete(Long id);
}
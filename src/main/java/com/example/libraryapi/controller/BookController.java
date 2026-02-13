package com.example.libraryapi.controller;

import com.example.libraryapi.dto.BookCreateRequest;
import com.example.libraryapi.dto.BookResponse;
import com.example.libraryapi.dto.BookUpdateRequest;
import com.example.libraryapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponse create(@Valid @RequestBody BookCreateRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<BookResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BookResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id, @Valid @RequestBody BookUpdateRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
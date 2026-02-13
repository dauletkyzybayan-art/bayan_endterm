package com.example.libraryapi.service.impl;

import com.example.libraryapi.dto.BookCreateRequest;
import com.example.libraryapi.dto.BookResponse;
import com.example.libraryapi.dto.BookUpdateRequest;
import com.example.libraryapi.exception.NotFoundException;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.model.EBook;
import com.example.libraryapi.model.PrintedBook;
import com.example.libraryapi.patterns.factory.BookFactory;
import com.example.libraryapi.patterns.singleton.LibraryConfigSingleton;
import com.example.libraryapi.repository.BookRepository;
import com.example.libraryapi.service.BookService;
import com.example.libraryapi.utils.BookMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository repo;
    private final BookMapper mapper;
    private final BookFactory factory = new BookFactory();

    public BookServiceImpl(BookRepository repo, BookMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public BookResponse create(BookCreateRequest req) {
        LibraryConfigSingleton.getInstance().getLibraryName();
        Book book = factory.create(req);
        Book saved = repo.save(book);
        return mapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponse> getAll() {
        return repo.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponse getById(Long id) {
        Book book = repo.findById(id).orElseThrow(() -> new NotFoundException("Book with id=" + id + " not found"));
        return mapper.toResponse(book);
    }

    @Override
    public BookResponse update(Long id, BookUpdateRequest req) {
        Book book = repo.findById(id).orElseThrow(() -> new NotFoundException("Book with id=" + id + " not found"));

        book.setTitle(req.getTitle());
        book.setAuthor(req.getAuthor());
        book.setYearPublished(req.getYearPublished());
        book.setIsbn(req.getIsbn());
        book.setPrice(req.getPrice());

        if (book instanceof EBook e) {
            e.setFileFormat(req.getFileFormat());
            e.setFileSizeMb(req.getFileSizeMb());
        } else if (book instanceof PrintedBook p) {
            p.setPages(req.getPages());
            p.setCoverType(req.getCoverType());
        }

        Book saved = repo.save(book);
        return mapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Book with id=" + id + " not found");
        }
        repo.deleteById(id);
    }
}
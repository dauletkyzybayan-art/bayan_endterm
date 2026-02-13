package com.example.libraryapi.utils;

import com.example.libraryapi.dto.BookResponse;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.model.EBook;
import com.example.libraryapi.model.PrintedBook;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponse toResponse(Book book) {
        BookResponse r = new BookResponse();
        r.setId(book.getId());
        r.setType(book.getType());
        r.setTitle(book.getTitle());
        r.setAuthor(book.getAuthor());
        r.setYearPublished(book.getYearPublished());
        r.setIsbn(book.getIsbn());
        r.setPrice(book.getPrice());

        if (book instanceof EBook e) {
            r.setFileFormat(e.getFileFormat());
            r.setFileSizeMb(e.getFileSizeMb());
        }

        if (book instanceof PrintedBook p) {
            r.setPages(p.getPages());
            r.setCoverType(p.getCoverType());
        }

        return r;
    }
}
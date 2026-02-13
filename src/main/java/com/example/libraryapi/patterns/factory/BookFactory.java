package com.example.libraryapi.patterns.factory;

import com.example.libraryapi.dto.BookCreateRequest;
import com.example.libraryapi.model.Book;
import com.example.libraryapi.model.BookType;
import com.example.libraryapi.patterns.builder.EBookBuilder;
import com.example.libraryapi.patterns.builder.PrintedBookBuilder;

public class BookFactory {

    public Book create(BookCreateRequest req) {
        BookType type = req.getType();

        return switch (type) {
            case EBOOK -> new EBookBuilder()
                    .title(req.getTitle())
                    .author(req.getAuthor())
                    .yearPublished(req.getYearPublished())
                    .isbn(req.getIsbn())
                    .price(req.getPrice())
                    .fileFormat(req.getFileFormat())
                    .fileSizeMb(req.getFileSizeMb())
                    .build();

            case PRINTED -> new PrintedBookBuilder()
                    .title(req.getTitle())
                    .author(req.getAuthor())
                    .yearPublished(req.getYearPublished())
                    .isbn(req.getIsbn())
                    .price(req.getPrice())
                    .pages(req.getPages())
                    .coverType(req.getCoverType())
                    .build();
        };
    }
}
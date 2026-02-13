package com.example.libraryapi.patterns.builder;

import com.example.libraryapi.model.PrintedBook;

import java.math.BigDecimal;

public class PrintedBookBuilder {

    private String title;
    private String author;
    private Integer yearPublished;
    private String isbn;
    private BigDecimal price;

    private Integer pages;
    private String coverType;

    public PrintedBookBuilder title(String title) { this.title = title; return this; }
    public PrintedBookBuilder author(String author) { this.author = author; return this; }
    public PrintedBookBuilder yearPublished(Integer yearPublished) { this.yearPublished = yearPublished; return this; }
    public PrintedBookBuilder isbn(String isbn) { this.isbn = isbn; return this; }
    public PrintedBookBuilder price(BigDecimal price) { this.price = price; return this; }
    public PrintedBookBuilder pages(Integer pages) { this.pages = pages; return this; }
    public PrintedBookBuilder coverType(String coverType) { this.coverType = coverType; return this; }

    public PrintedBook build() {
        return new PrintedBook(title, author, yearPublished, isbn, price, pages, coverType);
    }
}
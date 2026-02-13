package com.example.libraryapi.patterns.builder;

import com.example.libraryapi.model.EBook;

import java.math.BigDecimal;

public class EBookBuilder {

    private String title;
    private String author;
    private Integer yearPublished;
    private String isbn;
    private BigDecimal price;

    private String fileFormat;
    private BigDecimal fileSizeMb;

    public EBookBuilder title(String title) { this.title = title; return this; }
    public EBookBuilder author(String author) { this.author = author; return this; }
    public EBookBuilder yearPublished(Integer yearPublished) { this.yearPublished = yearPublished; return this; }
    public EBookBuilder isbn(String isbn) { this.isbn = isbn; return this; }
    public EBookBuilder price(BigDecimal price) { this.price = price; return this; }
    public EBookBuilder fileFormat(String fileFormat) { this.fileFormat = fileFormat; return this; }
    public EBookBuilder fileSizeMb(BigDecimal fileSizeMb) { this.fileSizeMb = fileSizeMb; return this; }

    public EBook build() {
        return new EBook(title, author, yearPublished, isbn, price, fileFormat, fileSizeMb);
    }
}
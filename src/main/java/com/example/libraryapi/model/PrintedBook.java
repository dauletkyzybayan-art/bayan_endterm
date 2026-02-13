package com.example.libraryapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("PRINTED")
public class PrintedBook extends Book {

    private Integer pages;

    @Column(name = "cover_type")
    private String coverType;

    protected PrintedBook() {}

    public PrintedBook(String title, String author, Integer yearPublished, String isbn, BigDecimal price,
                       Integer pages, String coverType) {
        super(title, author, yearPublished, isbn, price);
        this.pages = pages;
        this.coverType = coverType;
    }

    public Integer getPages() { return pages; }
    public void setPages(Integer pages) { this.pages = pages; }

    public String getCoverType() { return coverType; }
    public void setCoverType(String coverType) { this.coverType = coverType; }
}
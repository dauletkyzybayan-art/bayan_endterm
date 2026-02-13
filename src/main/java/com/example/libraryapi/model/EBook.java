package com.example.libraryapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("EBOOK")
public class EBook extends Book {

    @Column(name = "file_format")
    private String fileFormat;

    @Column(name = "file_size_mb")
    private BigDecimal fileSizeMb;

    protected EBook() {}

    public EBook(String title, String author, Integer yearPublished, String isbn, BigDecimal price,
                 String fileFormat, BigDecimal fileSizeMb) {
        super(title, author, yearPublished, isbn, price);
        this.fileFormat = fileFormat;
        this.fileSizeMb = fileSizeMb;
    }

    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }

    public BigDecimal getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(BigDecimal fileSizeMb) { this.fileSizeMb = fileSizeMb; }
}
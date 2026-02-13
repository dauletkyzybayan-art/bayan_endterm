package com.example.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public class BookUpdateRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private Integer yearPublished;
    private String isbn;
    private BigDecimal price;

    private String fileFormat;
    private BigDecimal fileSizeMb;

    private Integer pages;
    private String coverType;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Integer getYearPublished() { return yearPublished; }
    public void setYearPublished(Integer yearPublished) { this.yearPublished = yearPublished; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String fileFormat) { this.fileFormat = fileFormat; }

    public BigDecimal getFileSizeMb() { return fileSizeMb; }
    public void setFileSizeMb(BigDecimal fileSizeMb) { this.fileSizeMb = fileSizeMb; }

    public Integer getPages() { return pages; }
    public void setPages(Integer pages) { this.pages = pages; }

    public String getCoverType() { return coverType; }
    public void setCoverType(String coverType) { this.coverType = coverType; }
}
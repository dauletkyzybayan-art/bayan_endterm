package com.example.libraryapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private BookType type;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String author;

    @Column(name = "year_published")
    private Integer yearPublished;

    private String isbn;

    private BigDecimal price;

    protected Book() {}

    protected Book(String title, String author, Integer yearPublished, String isbn, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.price = price;
    }

    public Long getId() { return id; }

    public BookType getType() { return type; }

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
}
package com.example.ypjpa.data.model;

import jakarta.persistence.*;
import org.apache.commons.collections4.list.UnmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Book {


    @Id
    private String isbn;
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Author author;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String description;
    private int rating;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Author> coAuthors = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<InventoryObject> copies = new ArrayList<>();

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }


    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        if (!author.getBooks().contains(this)) {
            author.getBooks().add(this);
        }
        return this;
    }

    public List<Author> getCoAuthors() {
        return coAuthors;
    }

    public Book setCoAuthors(List<Author> coAuthors) {
        this.coAuthors = coAuthors;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public Book setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public List<InventoryObject> getCopies() {
        return new UnmodifiableList<>(copies);
    }

    public Book addCopy(InventoryObject copy) {
        if (!copies.contains(copy)) {
            copies.add(copy);
        }
        return this;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

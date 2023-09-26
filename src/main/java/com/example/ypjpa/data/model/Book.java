package com.example.ypjpa.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book implements BookInterface {

// isbn,title,author_uuid,genre,description,rating
    @Id
    private String isbn;
    private String title,genre,description;
    private int rating;

    @ManyToOne
    private Author author;

    @Override
    public String toString() {
        return this.title;
    }
}

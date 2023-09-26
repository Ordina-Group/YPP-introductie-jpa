package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Book implements BookInterface {

    @Id
    private String isbn;

    private String title;
    private String description;
    private int rating;

    @ManyToOne
    private Author author;

    @OneToOne
    private Inventory inventoryItem;

    @Override
    public String toString() {
        return "title: " + title;
    }

    @Override
    public Author getAuthor() {
        return author;
    }
}

package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book implements BookInterface {

    @Id
    private String isbn;

    private String title;

    @ManyToOne
    private Author author;

    @Override
    public String toString() {
        return title;
    }
}

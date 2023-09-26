package com.example.ypjpa.data.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Book implements BookInterface {

    @Id
    private String isbn;

    private String title, genre, description;
    private int rating;

    @ManyToOne
    private Author author;



    @Override
    public String toString() {
        return this.title;
    }


}
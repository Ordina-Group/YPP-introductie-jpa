package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter
public class Book implements BookInterface {

    @Id
    private Long isbn;
    private String title;

    private UUID author_Uuid;
    private String genre;

    private String description;

    private int rating;

    @OneToOne
    private Author author;

    @Override
    public String toString() {
        return ""; //todo should contain at least title
    }
}

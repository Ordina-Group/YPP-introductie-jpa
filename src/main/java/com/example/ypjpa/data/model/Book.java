package com.example.ypjpa.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter
public class Book implements BookInterface {

    @Id
    private String isbn;
    private String title;

    private String genre;

    private String description;

    private int rating;

    @OneToOne
    private Author author;

    @OneToOne
    InventoryItem inventoryItem;

    @Override
    public String toString() {
        return ""; //todo should contain at least title
    }
}

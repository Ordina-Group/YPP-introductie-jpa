package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Author implements AuthorInterface {

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private String initials;
    private Date dateOfBirth;

    @OneToMany
    private List<Book> books;

    @OneToOne
    private InventoryItem inventoryItem;

    @Override
    public List<Book> getBooks(){
        return books;
    }
}

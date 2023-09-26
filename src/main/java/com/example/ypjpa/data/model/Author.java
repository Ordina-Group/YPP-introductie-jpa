package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Author implements AuthorInterface {

    @Id
    private UUID uuid;
    private String firstName;
    private String initials;
    private String lastName;

    private Date dateOfBirth;

    @OneToMany
    private List<Book> book;

}

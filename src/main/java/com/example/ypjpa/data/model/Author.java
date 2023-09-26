package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Author implements AuthorInterface {

    @Id
    private UUID uuid;

    private String firstName, initials, lastName;

    private Date date_of_birth;

   @OneToMany
    private List<Book> book;
}

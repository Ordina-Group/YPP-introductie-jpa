package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Author implements AuthorInterface {

    @Id
    private String uuid;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    @OneToMany
    private List<Book> book;

    @Override
    public String toString() {
        return "Book{" +
                "uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

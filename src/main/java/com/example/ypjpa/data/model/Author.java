package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity //todo bespreken gebruik element collection vs one to many
public class Author implements AuthorInterface {

    @Id
    private UUID uuid;
    //todo question: an java object become to large what is a good way to decrease the size, withouth changing the db structure?
    private String firstName;
    private String initials;
    private String lastName;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public UUID getUuid() {
        return uuid;
    }

    public Author setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getInitials() {
        return initials;
    }

    public Author setInitials(String initials) {
        this.initials = initials;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Author setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}

package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Author implements AuthorInterface {

    @Id
    private UUID uuid;
    private String firstName;

    private String initials;
    private String lastName;

    private Date dateOfBirth;

    @OneToOne
    private Book book;

}

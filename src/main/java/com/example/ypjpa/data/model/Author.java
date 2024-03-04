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
public class Author implements AuthorInterface {

    @Id
    private UUID uuid;
    private String first_Name;

    private String initials;
    private String last_Name;

    @OneToOne
    private Book book;

}

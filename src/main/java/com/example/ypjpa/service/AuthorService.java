package com.example.ypjpa.service;

import com.example.ypjpa.data.AuthorRepository;
import com.example.ypjpa.data.model.Book;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Book findByLastName(String lastName) {
        return repository.findByLastName(lastName)
                .stream()
                .flatMap(author -> author.getBooks().stream())
                .findFirst().orElseThrow();
    }
}

package com.example.ypjpa.service;

import com.example.ypjpa.data.InventoryRepository;
import com.example.ypjpa.data.model.Book;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final InventoryRepository repository;

    public AuthorService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Book findByLastName(String lastName) {
        return repository.findFirstByBook_Author_LastName(lastName).getBook();
    }
}

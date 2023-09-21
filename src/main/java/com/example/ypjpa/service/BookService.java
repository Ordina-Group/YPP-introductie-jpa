package com.example.ypjpa.service;

import com.example.ypjpa.data.BookRepository;
import com.example.ypjpa.data.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addObject(Book book) {
        repository.save(book);
    }

    public Book findBook(String isbn) {
        return repository.findByIsbn(isbn);
    }
}

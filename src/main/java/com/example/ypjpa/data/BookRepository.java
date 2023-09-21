package com.example.ypjpa.data;


import com.example.ypjpa.data.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {
    void save(Book book);

    Book findByIsbn(String isbn);
}

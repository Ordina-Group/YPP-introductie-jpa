package com.example.ypjpa.testutil;

import com.example.ypjpa.data.model.Book;

import java.util.List;

public interface AuthorInterface {


    default List<Book> getBooks() {
        return List.of();
    }
}

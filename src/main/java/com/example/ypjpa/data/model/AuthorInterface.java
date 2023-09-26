package com.example.ypjpa.data.model;

import java.util.List;

public interface AuthorInterface {

    default List<Book> getBooks() {
        return List.of();
    }
}

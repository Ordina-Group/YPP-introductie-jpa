package com.example.ypjpa.data.model;

public interface BookInterface {
    default AuthorInterface getAuthor() {
        return null;
    }
}

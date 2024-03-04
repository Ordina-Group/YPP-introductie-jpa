package com.example.ypjpa.testutil;

public interface BookInterface {
    default AuthorInterface getAuthor() {
        return null;
    }
}

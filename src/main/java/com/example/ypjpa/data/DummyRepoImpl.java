package com.example.ypjpa.data;

import com.example.ypjpa.data.model.Author;
import com.example.ypjpa.data.model.Book;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyRepoImpl implements BookRepository, AuthorRepository {
    @Override
    public void save(Book book) {

    }

    @Override
    public Book findByIsbn(String isbn) {
        throw new NotImplementedException();
    }

    @Override
    public List<Author> findByLastName(String lastName) {
        throw new NotImplementedException();
    }
}

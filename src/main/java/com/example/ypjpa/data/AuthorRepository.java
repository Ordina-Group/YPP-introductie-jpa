package com.example.ypjpa.data;


import com.example.ypjpa.data.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository {
    List<Author> findByLastName(String lastName);
}

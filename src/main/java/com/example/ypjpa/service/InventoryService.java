package com.example.ypjpa.service;

import com.example.ypjpa.data.InventoryRepository;
import com.example.ypjpa.data.model.Book;
import com.example.ypjpa.data.model.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void addObject(Inventory inventoryObject) {
        repository.save(inventoryObject);
    }

    public Book findBook(String isbn) {
        return repository.findFirstByBook_Isbn(isbn).getBook();
    }

    @Transactional
    public List<Book> findBooksByAuthor(String lastname) {
        return repository.findFirstByBook_Author_LastName(lastname).getBook().getAuthor().getBooks();
    }

    public void addCopy(String isbn, String barcode) {
        //todo
        throw new UnsupportedOperationException();
    }
}

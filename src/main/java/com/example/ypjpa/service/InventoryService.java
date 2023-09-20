package com.example.ypjpa.service;

import com.example.ypjpa.data.InventoryRepository;
import com.example.ypjpa.data.model.Book;
import com.example.ypjpa.data.model.InventoryObject;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public void addObject(InventoryObject inventoryObject) {
        repository.save(inventoryObject);
    }

    public Book findBook(String isbn) {
        return repository.findFirstByBook_Isbn(isbn).getBook();
    }

    /*todo question:
       what are other ways to archieve this?
       can it be done using @Query?
       can it be done using derived query from the existing InvenotoryRepository?
       can it be done in another way?
       what is the best way to do it?
     */
    @Transactional
    public List<Book> findBooksByAuthor(String lastname) {
        return repository.findFirstByBook_Author_LastName(lastname).getBook().getAuthor().getBooks();
    }

    @Transactional //todo question: why is this neccessary?
    public void addCopy(String isbn, String barcode) {
        Book book = findBook(isbn);
        book.addCopy(new InventoryObject().setBook(book).setBarcode(barcode).setQuantity(1).setPriceInEuro(5));
    }
}

package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class InventoryItem implements InventoryItemInterface {

    @Id
    private String barcode;

    private Long quantity;
    private Double price_in_Euro;

    private String description;

    private Long book_Isbn;

    @OneToOne(mappedBy = "InventoryItem")
    Book book;

    @Override
    public Book getBook() {
        return InventoryItemInterface.super.getBook();
    }
}

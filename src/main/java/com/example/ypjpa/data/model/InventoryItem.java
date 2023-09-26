package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class InventoryItem implements InventoryItemInterface {

    @OneToOne
    private Book book;

    @OneToOne
    private Author author;

    @Override
    public Book getBook() {
        return InventoryItemInterface.super.getBook();
    }
}

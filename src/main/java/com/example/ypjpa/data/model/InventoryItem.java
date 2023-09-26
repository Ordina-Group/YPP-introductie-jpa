package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Inventory")
public class InventoryItem implements InventoryItemInterface {

    @Id
    private String barcode;

    private Double priceInEuro;

    @OneToOne
    private Book book;

    @Override
    public Book getBook() {
        return this.book;
    }


}

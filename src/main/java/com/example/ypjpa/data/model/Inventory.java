package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Inventory implements InventoryInterface {

    @Id
    private String barcode;

    private int quantity;

    private double priceInEuro;

    @OneToOne
    private Book book;

    @Override
    public Book getBook() {
        return this.book;
    }
}

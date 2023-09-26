package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "Inventory")
public class Inventory implements InventoryInterface {
    @Id
    private String barcode;

    private int quantity;
    private Double price_in_euro;

    @OneToOne
    private Book book;


    @Override
    public Book getBook() {
        return this.book;
    }

}
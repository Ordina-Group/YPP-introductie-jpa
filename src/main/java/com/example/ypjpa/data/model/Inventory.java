package com.example.ypjpa.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "inventory")
//@Table(name="inventory")
public class Inventory implements InventoryInterface {

    @Id
    private String barcode;

    private int quantity;

    private float priceInEuro;

    @OneToOne
    private Book book;

    @Override
    public Book getBook() {
        return book;
    }
}

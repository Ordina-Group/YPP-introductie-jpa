package com.example.ypjpa.data.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "inventory")
public class InventoryObject {

    @Id
    private String barcode;
    private Integer quantity;
    private double priceInEuro;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "book_isbn", nullable = false)
    private Book book;


    public String getBarcode() {
        return barcode;
    }

    public InventoryObject setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public InventoryObject setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }

    public InventoryObject setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public InventoryObject setBook(Book book) {
        this.book = book;
        if (!book.getCopies().contains(this)) {
            book.addCopy(this);
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryObject that = (InventoryObject) o;
        return Objects.equals(barcode, that.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode);
    }
}

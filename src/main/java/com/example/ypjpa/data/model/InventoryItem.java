package com.example.ypjpa.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "inventory")
public class InventoryItem implements InventoryItemInterface {

    @Id
    @Column(name = "barcode")
    private String barcode;

    private Long quantity;
    private Double priceInEuro;

    @OneToOne
    Book book;

    @Override
    public Book getBook() {
        return InventoryItemInterface.super.getBook();
    }
}

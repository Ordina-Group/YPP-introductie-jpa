package com.example.ypjpa.data.model;

public class InventoryItem implements InventoryItemInterface {
    @Override
    public Book getBook() {
        return InventoryItemInterface.super.getBook();
    }
}

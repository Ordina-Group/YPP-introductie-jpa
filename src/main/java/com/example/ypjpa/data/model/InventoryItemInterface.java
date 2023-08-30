package com.example.ypjpa.data.model;

public interface InventoryItemInterface {


    default Book getBook() {
        return null;
    }

}

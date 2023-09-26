package com.example.ypjpa.data.model;

public interface InventoryInterface {


    default Book getBook() {
        return null;
    }

}

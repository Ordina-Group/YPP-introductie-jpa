package com.example.ypjpa.data.model;

import com.example.ypjpa.testutil.InventoryItemInterface;

public class InventoryItem implements InventoryItemInterface {
    @Override
    public Book getBook() {
        return InventoryItemInterface.super.getBook();
    }
}

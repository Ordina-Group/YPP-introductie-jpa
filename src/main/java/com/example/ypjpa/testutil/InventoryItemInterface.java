package com.example.ypjpa.testutil;

import com.example.ypjpa.data.model.Book;

public interface InventoryItemInterface {


    default Book getBook() {
        return null;
    }

}

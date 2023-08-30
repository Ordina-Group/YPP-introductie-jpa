package com.example.ypjpa.data;


import com.example.ypjpa.data.model.InventoryItem;

public interface InventoryRepository {
    InventoryItem findFirstByBook_Isbn(String isbn);

    InventoryItem findFirstByBook_Author_LastName(String lastname);

    void save(InventoryItem inventoryObject);
}

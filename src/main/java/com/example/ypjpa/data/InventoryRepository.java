package com.example.ypjpa.data;


import com.example.ypjpa.data.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<InventoryItem, String> {
    InventoryItem findFirstByBook_Isbn(String isbn);

    InventoryItem findFirstByBook_Author_LastName(String lastname);
}

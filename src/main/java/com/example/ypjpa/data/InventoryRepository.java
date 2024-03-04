package com.example.ypjpa.data;


import com.example.ypjpa.data.model.InventoryItem;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository <InventoryItem,String> {
    InventoryItem findFirstByBook_Isbn(String isbn);

    InventoryItem findFirstByBook_Author_LastName(String lastname);

}

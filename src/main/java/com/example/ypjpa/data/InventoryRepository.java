package com.example.ypjpa.data;


import com.example.ypjpa.data.model.InventoryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryObject, String> {
    InventoryObject findFirstByBook_Isbn(String isbn);

    InventoryObject findFirstByBook_Author_LastName(String lastname);
}

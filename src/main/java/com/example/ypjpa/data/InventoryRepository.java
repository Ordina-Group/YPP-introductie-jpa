package com.example.ypjpa.data;

import com.example.ypjpa.data.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {
    Inventory findFirstByBook_Isbn(String isbn);

    Inventory findFirstByBook_Author_LastName(String lastname);
}

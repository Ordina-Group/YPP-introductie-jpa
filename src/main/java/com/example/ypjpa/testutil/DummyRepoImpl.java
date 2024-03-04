package com.example.ypjpa.testutil;

import com.example.ypjpa.data.InventoryRepository;
import com.example.ypjpa.data.model.InventoryItem;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Component;

@Component
public class DummyRepoImpl implements InventoryRepository {

    public InventoryItem findFirstByBook_Isbn(String isbn) {
        throw new NotImplementedException("Not implemented");
    }

    public InventoryItem findFirstByBook_Author_LastName(String lastname) {
        throw new NotImplementedException("Not implemented");
    }

    @Override
    public void save(InventoryItem inventoryObject) {
        throw new NotImplementedException("Not implemented");
    }
}

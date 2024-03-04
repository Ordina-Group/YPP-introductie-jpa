package com.example.ypjpa.data.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepositorys extends CrudRepository<InventoryItem, String> {


}

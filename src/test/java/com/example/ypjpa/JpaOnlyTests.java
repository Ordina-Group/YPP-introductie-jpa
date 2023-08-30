package com.example.ypjpa;

import com.example.ypjpa.service.InventoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.liquibase.enabled=false",
        "spring.jpa.hibernate.ddl-auto=create"})

@Transactional
public class JpaOnlyTests {

    @Autowired
    private InventoryService inventoryService;

}

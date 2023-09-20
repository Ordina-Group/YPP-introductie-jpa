package com.example.ypjpa;

import com.example.ypjpa.data.model.Author;
import com.example.ypjpa.data.model.Book;
import com.example.ypjpa.data.model.Genre;
import com.example.ypjpa.data.model.InventoryObject;
import com.example.ypjpa.service.InventoryService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"spring.liquibase.enabled=false",
        "spring.jpa.hibernate.ddl-auto=create"})

@Transactional //todo bespreken waarom transactional?
public class JpaOnlyTests {

    @Autowired
    private InventoryService inventoryService;

    @Nested
    class GivenBookInDB {

        private String isbnOfBookInDB;
        private String barCodeOfBookInDB;
        private String authorLastName;

        @BeforeEach
        void setUp() {
            isbnOfBookInDB = "isbn";
            barCodeOfBookInDB = UUID.randomUUID().toString();
            authorLastName = "Patel";
            InventoryObject inventoryObject = new InventoryObject()
                    .setBook(new Book()
                            .setIsbn(isbnOfBookInDB)
                            .setTitle("Spring Boot")
                            .setAuthor(new Author()
                                    .setUuid(UUID.randomUUID())
                                    .setFirstName("Piet")
                                    .setDateOfBirth(LocalDate.now().minusYears(30))
                                    .setLastName(authorLastName)
                            )
                            .setGenre(Genre.ACTION)
                            .setDescription("Description"))
                    .setBarcode(barCodeOfBookInDB)
                    .setPriceInEuro(5)
                    .setQuantity(10);
            inventoryService.addObject(inventoryObject);
        }

        @Nested
        class WhenCopyIsAdded {

            @BeforeEach
            void setUp() {
                inventoryService.addCopy(isbnOfBookInDB, "newBarCode");
            }

            @Test
            void inventoryContains11() {
                Book book = inventoryService.findBook(isbnOfBookInDB);
                assertThat(book.getCopies().stream().map(InventoryObject::getQuantity).reduce(0, Integer::sum))
                        .isEqualTo(11);
            }

            @Test
            void authorHasBook() {
                assertThat(inventoryService.findBooksByAuthor(authorLastName)).hasSize(1);
            }
        }
    }

}

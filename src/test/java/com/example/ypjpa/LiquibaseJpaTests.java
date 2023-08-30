package com.example.ypjpa;

import com.example.ypjpa.data.model.Book;
import com.example.ypjpa.service.AuthorService;
import com.example.ypjpa.service.InventoryService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("liquibasetest")
@Transactional
class LiquibaseJpaTests {

	@Autowired
	InventoryService inventoryService;

	@Autowired
	AuthorService authorService;

	@Test
	void givenBookInDb_whenFindByISBN_ThenBookIsFound() {
		Book book = inventoryService.findBook("978-3-16-148410-0");
		assertThat(book.toString()).contains("Book One");
		//todo additional testing
	}

	@Test
	void givenAuthorInDb_whenFindByLastName_ThenBookIsFound() {
		Book book = authorService.findByLastName("Doe");
		assertThat(book.toString()).contains("Book One");
		//todo additional testing
	}

}

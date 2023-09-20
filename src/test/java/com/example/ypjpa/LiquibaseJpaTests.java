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
		assertThat(book.getIsbn()).isEqualTo("978-3-16-148410-0");
		assertThat(book.getTitle()).isEqualTo("Book One");
		assertThat(book.getDescription()).isEqualTo("An action-packed book.");
		assertThat(book.getRating()).isEqualTo(4);
		assertThat(book.getCopies().stream()
				.map(inventoryObject -> inventoryObject.getQuantity())
				.reduce(0, Integer::sum)
		).isEqualTo(10);
		assertThat(book.getAuthor().getLastName()).isEqualTo("Doe");
		assertThat(book.getAuthor().getFirstName()).isEqualTo("John");

	}

	@Test
	void givenAuthorInDb_whenFindByLastName_ThenBookIsFound() {
		Book book = authorService.findByLastName("Doe");
		assertThat(book.toString()).contains("Book One");
	}

}

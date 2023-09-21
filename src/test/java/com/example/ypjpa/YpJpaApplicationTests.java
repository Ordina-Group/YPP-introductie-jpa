package com.example.ypjpa;

import com.example.ypjpa.data.model.Book;
import com.example.ypjpa.service.AuthorService;
import com.example.ypjpa.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("liquibasetest")
class YpJpaApplicationTests {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorService authorService;

	@Test
	void givenBookInDb_whenFindByISBN_ThenBookIsFound() {
		Book book = bookService.findBook("f47ac10b-58cc-4372-a567-0e02b2c3d479");
		assertThat(book.toString()).contains("Sample Book");
	}

	@Test
	void givenAuthorInDb_whenFindByLastName_ThenBookIsFound() {
		Book book = authorService.findByLastName("Doe");
		assertThat(book.toString()).contains("Sample Book");
	}

}

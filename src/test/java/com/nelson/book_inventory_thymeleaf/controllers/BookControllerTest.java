package com.nelson.book_inventory_thymeleaf.controllers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nelson.book_inventory_thymeleaf.models.Author;
import com.nelson.book_inventory_thymeleaf.models.Book;
import com.nelson.book_inventory_thymeleaf.models.Gender;
import com.nelson.book_inventory_thymeleaf.models.Genre;
import com.nelson.book_inventory_thymeleaf.repositories.IBookRepository;
import com.nelson.book_inventory_thymeleaf.services.BookService;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
	
	private Author authorId;
	private Book book;
	private Genre genreId;
	private Optional<Book> bookOp;
	private final Integer ISBN= 123456;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	IBookRepository repository;
	
	@InjectMocks
	BookService service;
	
	private ObjectMapper objM = new ObjectMapper();
	
	@BeforeEach
	void beforeEach() {
		authorId = new Author(2, "paulo modified", "cohelo", null, null, null);
		book = new Book();
		genreId = new Genre(11, "COMEDY", null);
		book.setBookIsbn(ISBN);
		book.setAuthorId(authorId); 
		book.setGenreId(genreId);
		book.setTitle("My Book");
		book.setStock(10);
		book.setPrice(19.90);
		book.setPages(250);
		bookOp = Optional.of(book);
	}
	
	@Nested
	class integrationTest{		
		@Test
		void deleteBookById() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.delete("/book/123456"))
			.andExpect(MockMvcResultMatchers.status().isOk());
		}
		
		//just change the number in the bookIsbn, since bookIsbn : 23565245 already exists
		//it will give a 406 error
		@Test
		@DisplayName("insert book by Id test")
		void insertBookSuccess() throws Exception{
			mockMvc.perform(MockMvcRequestBuilders.post("/book")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objM.writeValueAsString(book)))
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
		
		@Test
		@DisplayName("select all books test")
		void selectBookSuccess() throws Exception{
			mockMvc.perform(MockMvcRequestBuilders.get("/book")
					.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
		
		
		@Test
		void selectById() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/book/123456")
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
		
		@Test
		void updateById() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.put("/book/123456")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\r\n"
							+ "    \"title\": \"title modified\",\r\n"
							+ "    \"stock\": 345\r\n"
							+ "}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
		
	}
	
	@Nested
	class unitTesting{
		
		@Test
		@DisplayName("test for select All books")
		void selectById() {
			when(repository.findById(anyInt())).thenReturn(bookOp);
			
			assertAll( () -> {
					assertNotNull(service.selectById(ISBN));				
				}, () -> {
					assertEquals("My Book", service.selectById(ISBN).getTitle());				
				}, () -> {				
					assertTrue(book.equals(service.selectById(ISBN)));
				}, () -> {				
					assertTrue(genreId.equals(service.selectById(ISBN).getGenreId()));
				}, () -> {				
					assertTrue(authorId.equals(service.selectById(ISBN).getAuthorId()));
				}, () -> {
					assertEquals(123456, service.selectById(ISBN).getBookIsbn());
				}
			);
		}
		
		@Test
		void selectAll() {
			Author author2 = new Author(4, "Miguel", "De Cervantes", "Spain", Gender.M, null);
			Genre genre2 = new Genre(5, "NOVEL", null);
			Book book2 = new Book(67890, author2, genre2, "Don Quixote", 1232, 234.23, null, null);
			
			when(repository.findAll()).thenReturn(Stream.of(book, book2).collect(Collectors.toList()));
			
			assertAll( () -> {
					assertNotNull(service.select());
					verify(repository).findAll();
				}, () -> {
					assertEquals(2, service.select().size());
				}, () -> {
					assertTrue(service.select().contains(book));
				}
			
			);
		}
		
	}
	
	
}

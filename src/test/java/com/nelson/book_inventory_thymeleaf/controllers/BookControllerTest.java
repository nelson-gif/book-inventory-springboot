package com.nelson.book_inventory_thymeleaf.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void selectBookSuccess() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/book")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
//	@Test
//	public void insertBookSuccess() throws Exception{
//		mockMvc.perform(MockMvcRequestBuilders.post("/book")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content("{\r\n"
//						+ "    \"bookIsbn\" : 23565245,\r\n"
//						+ "    \"genreId\" : {\r\n"
//						+ "        \"genreId\" : 11,\r\n"
//						+ "        \"genre\" : \"COMEDY\"\r\n"
//						+ "    },\r\n"
//						+ "    \"authorId\":{\r\n"
//						+ "        \"authorId\" : 3,\r\n"
//						+ "        \"name\" : \"paulo\",\r\n"
//						+ "        \"lastName\" : \"cohelsdfo\"\r\n"
//						+ "    },\r\n"
//						+ "    \r\n"
//						+ "    \"title\": \"Don Quijote\",\r\n"
//						+ "    \"stock\": 10,\r\n"
//						+ "    \"price\": 19.99,\r\n"
//						+ "    \"pages\": 1234,\r\n"
//						+ "    \"publicationDate\": \"1605-01-16\"\r\n"
//						+ "}"))
//			.andExpect(MockMvcResultMatchers.status().isCreated())
//			.andExpect(MockMvcResultMatchers.content()
//					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//	}
	
	
}

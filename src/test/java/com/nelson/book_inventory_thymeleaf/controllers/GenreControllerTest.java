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
public class GenreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void selectGenreSucces() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/genre")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
			
	}
	
}

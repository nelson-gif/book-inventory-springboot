package com.nelson.book_inventory_thymeleaf.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelson.book_inventory_thymeleaf.models.Author;
import com.nelson.book_inventory_thymeleaf.services.IService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	@Qualifier("author")
	IService<Author> authorService;
	
	//Create - insert
	@PostMapping
	public ResponseEntity<Author> insertAuthor(@RequestBody Author author){
		return authorService.insert(author);
	}
	
	//Read - select *
	@GetMapping
	public ArrayList<Author> selectAuthor(){
		return authorService.select();
	}
	
	//Read - select by id
	@GetMapping(path="/{id}")
	public Author selectAuthorById(@PathVariable("id") Integer id) {
		return authorService.selectById(id);
	}
	
	//update
	@PutMapping(path="/{id}")
	public Author updateAuthorById(@RequestBody Author author, @PathVariable("id") Integer id) {
		return authorService.updateById(author, id);
	}
	
	//delete
	@DeleteMapping(path="/{id}")
	public Boolean deleteAuthorById(@PathVariable("id") Integer id) {
		return authorService.deleteById(id);
	}
	
}

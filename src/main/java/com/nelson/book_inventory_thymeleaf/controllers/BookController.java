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

import com.nelson.book_inventory_thymeleaf.models.Book;
import com.nelson.book_inventory_thymeleaf.services.IService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	@Qualifier("book")
	IService<Book> bookServ;
	
	//insert
	@PostMapping
	public ResponseEntity<Book> insertBook(@RequestBody Book book){
		return bookServ.insert(book);
	}
	
	//select
	@GetMapping
	public ArrayList<Book> selectBook(){
		return bookServ.select();
	}
	
	//select by id
	@GetMapping(path="/{id}")
	public Book selectBookById(@PathVariable("id") Integer id) {
		return bookServ.selectById(id);
	}
	
	//update
	@PutMapping(path="/{id}")
	public Book updateBookById(@RequestBody Book book, @PathVariable("id") Integer id) {
		return bookServ.updateById(book, id);
	}
	
	//delete
	@DeleteMapping(path="/{id}")
	public Boolean deleteBookById(@PathVariable("id") Integer id) {
		return bookServ.deleteById(id);
	}
	
}

package com.nelson.book_inventory_thymeleaf.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nelson.book_inventory_thymeleaf.models.Book;
import com.nelson.book_inventory_thymeleaf.repositories.IBookRepository;

@Service("book")
public class BookService implements IService<Book>{
	
	@Autowired
	IBookRepository bookRepo;

	//create - insert 
	@Override
	public ResponseEntity<Book> insert(Book book) {
		
		Optional<Book> bookOp = select().stream()
				.filter( element -> element.equals(book))
				.findFirst();
		
		if(bookOp.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Book already exists");
		}
		
		return new ResponseEntity<Book>(bookRepo.save(book), HttpStatus.CREATED);
	}

	@Override
	public ArrayList<Book> select() {
		return (ArrayList<Book>)bookRepo.findAll();
	}

	@Override
	public Book selectById(Integer id) {
		Book book = bookRepo.findById(id).orElse(null);
		if(book == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id provided doesn't exist");
		}
		return book;
	}

	@Override
	public Book updateById(Book newBook, Integer id) {
		
		if(bookRepo.findById(id) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id provided doesn't exist");
		}
		
		Book book = bookRepo.findById(id).get();
		book.setTitle(newBook.getTitle());
		book.setStock(newBook.getStock());
		
		return bookRepo.save(book);
	}

	@Override
	public Boolean deleteById(Integer id) {
		try {
			bookRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
}

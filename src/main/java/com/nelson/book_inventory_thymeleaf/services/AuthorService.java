package com.nelson.book_inventory_thymeleaf.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nelson.book_inventory_thymeleaf.models.Author;
import com.nelson.book_inventory_thymeleaf.repositories.IAuthorRepository;

@Service("author")
public class AuthorService implements IService<Author>{
	
	@Autowired
	IAuthorRepository authorRepo;
	
	//insert - create
	@Override
	public ResponseEntity<Author> insert(Author author){
		if(author.getName() == null || author.getLastName() == null) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "name or lastName cannot be null");
		}
		
		Optional<Author> authorOp = select().stream()
				.filter( element -> element.equals(author))
				.findFirst();
		if(authorOp.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Author already exists");
		}
		
		return new ResponseEntity<Author>(authorRepo.save(author), HttpStatus.CREATED);
	}
	
	//select * from author - read
	@Override
	public ArrayList<Author> select(){
		return (ArrayList<Author>)authorRepo.findAll();
	} 
	
	//select * from author where id = {id} - read
	@Override
	public Author selectById(Integer id) {
		
		Author author= authorRepo.findById(id).orElse(null);
		
		if(author == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id provided doesn't exist in the database");
		}
		
		return author;
	}
	
	//update 
	@Override
	public Author updateById(Author newAuthor, Integer id) {
		
		Optional<Author> authorOp = select().stream()
				.filter( element -> element.getAuthorId() == id)
				.findFirst();
		
		if(!authorOp.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id provided doesn't exist in the database");
		}
		
		Author author = authorRepo.findById(id).get();
		author.setName(newAuthor.getName());
		author.setLastName(newAuthor.getLastName());
		author.setCountry(newAuthor.getCountry());
		
		
		return authorRepo.save(author);
	}
	
	//delete
	@Override
	public Boolean deleteById(Integer id) {
		try {
			authorRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}

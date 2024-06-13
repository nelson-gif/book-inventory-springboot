package com.nelson.book_inventory_thymeleaf.controllers;

import java.util.List;

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

import com.nelson.book_inventory_thymeleaf.models.Genre;
import com.nelson.book_inventory_thymeleaf.services.IService;

@RestController
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	@Qualifier("genre")
	IService<Genre> genreServ;
	
	//insert
	@PostMapping
	public ResponseEntity<Genre> insertGenre(@RequestBody Genre genre) {
		//Object genre = genre1;
		return genreServ.insert(genre);
	}
	
	//select *
	@GetMapping
	public List<Genre> selectGenre(){
		return genreServ.select();
	}
	
	//select by id
	@GetMapping(path="/{id}")
	public Genre getGenreById(@PathVariable("id") Integer id){
		return genreServ.selectById(id);
	}
	
	//update
	@PutMapping(path="/{id}")
	public Genre updateGenreById(@RequestBody Genre genre, @PathVariable("id") Integer id) {
		return genreServ.updateById(genre, id);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public Boolean deleteGenreById(@PathVariable("id") Integer id) {
		return genreServ.deleteById(id);
	}
	
} 

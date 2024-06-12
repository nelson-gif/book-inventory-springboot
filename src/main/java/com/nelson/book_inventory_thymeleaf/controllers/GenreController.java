package com.nelson.book_inventory_thymeleaf.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nelson.book_inventory_thymeleaf.models.Genre;
import com.nelson.book_inventory_thymeleaf.services.GenreService;

@RestController
@RequestMapping("genre")
public class GenreController {
	
	@Autowired
	GenreService genreServ;
	
	//select *
	@GetMapping
	public List<Genre> selectGenre(){
		return this.genreServ.selectGenre();
	}
	
	//select by id
	@GetMapping(path="/{id}")
	public Optional<Genre> getGenreById(@PathVariable("id") Integer id){
		return this.genreServ.getGenreById(id);
	}
	
	//insert
	@PostMapping
	public Genre insertGenre(@RequestBody Genre genre) {
		return genreServ.insertGenre(genre);
	}
	
	//update
	@PutMapping(path="/{id}")
	public Genre updateGenreById(@RequestBody Genre genre, @PathVariable("id") Integer id) {
		return genreServ.updateGenreById(genre, id);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public Boolean deleteGenreById(@PathVariable("id") Integer id) {
		return genreServ.deleteGenre(id);
	}
	
} 

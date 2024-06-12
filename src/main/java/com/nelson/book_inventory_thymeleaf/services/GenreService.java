package com.nelson.book_inventory_thymeleaf.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nelson.book_inventory_thymeleaf.models.Genre;
import com.nelson.book_inventory_thymeleaf.repositories.IGenreRepository;

@Service
public class GenreService{
	
	@Autowired
	IGenreRepository genreRepo;
	
	//select
	public ArrayList<Genre> selectGenre(){
		return (ArrayList<Genre>)genreRepo.findAll();
	}
	
	//selectById
	public Genre getGenreById(Integer id){
		Genre genre = genreRepo.findById(id).orElse(null);
		
		if(genre == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id provided doesn't exist in the database");
		}
		
		return genre;
	}
	
	//insert
	public ResponseEntity<Genre> insertGenre(Genre genre) {
		if(genre.getGenre() == null) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "genre value cannot be null");
		}
		Optional<Genre> genreOptional = selectGenre()
				.stream()
				.filter(element -> element.equals(genre))
				.findFirst();
		
		if(genreOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Genre already exists");
		}
		
		return new ResponseEntity<Genre>(genreRepo.save(genre), HttpStatus.CREATED);
	}
	
	//delete
	public Boolean deleteGenre(Integer id) {
		try {
			genreRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	//update
	public Genre updateGenreById(Genre newGenre, Integer id) {
		
		Optional<Genre> genreOptional = selectGenre()
				.stream()
				.filter(element -> element.getIdGenre() == id)
				.findFirst();
		
		if(!genreOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre doens't exists");
		}
		
		Genre genre = genreRepo.findById(id).get();
		
		genre.setGenre(newGenre.getGenre());
		genre.setDescription(newGenre.getDescription());
		
		return genreRepo.save(genre);
	}
	

}
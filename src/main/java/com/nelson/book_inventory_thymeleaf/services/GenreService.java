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

@Service("genre")
public class GenreService implements IService<Genre>{
	
	@Autowired
	IGenreRepository genreRepo;
	
	//insert
	@Override
	public ResponseEntity<Genre> insert(Genre genre) {
		if(genre.getGenre() == null) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "genre value cannot be null");
		}
		Optional<Genre> genreOptional = select()
				.stream()
				.filter(element -> element.equals(genre))
				.findFirst();
		
		if(genreOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Genre already exists");
		}
		
		return new ResponseEntity<Genre>(genreRepo.save(genre), HttpStatus.CREATED);
	}
	
	//select
	@Override
	public ArrayList<Genre> select(){
		return (ArrayList<Genre>)genreRepo.findAll();
	}
	
	//selectById
	@Override
	public Genre selectById(Integer id){
		Genre genre = genreRepo.findById(id).orElse(null);
		
		if(genre == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id provided doesn't exist in the database");
		}
		
		return genre;
	}
	
	//update
	@Override
	public Genre updateById(Genre newGenre, Integer id) {
		Optional<Genre> genreOptional = select()
				.stream()
				.filter(element -> element.getGenreId() == id)
				.findFirst();
		
		if(!genreOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre doens't exists");
		}
		
		Genre genre = genreRepo.findById(id).get();
		
		genre.setGenre(newGenre.getGenre());
		genre.setDescription(newGenre.getDescription());
		
		return genreRepo.save(genre);
	}
	
	//delete
	@Override
	public Boolean deleteById(Integer id) {
		try {
			genreRepo.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
package com.nelson.book_inventory_thymeleaf.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelson.book_inventory_thymeleaf.models.Genre;
import com.nelson.book_inventory_thymeleaf.repositories.IGenreRepository;

@Service
public class GenreService {
	
	@Autowired
	IGenreRepository genreRepo;
	
	//select
	public ArrayList<Genre> selectGenre(){
		return (ArrayList<Genre>)genreRepo.findAll();
	}
	
//	public Integer returnId(String genre) {
//		Integer id= 0;
//		for(Genre element: selectGenre()) {
//			if(element.getGenre().equalsIgnoreCase(genre)) {
//				id = element.getIdGenre();
//			}
//		}
//		return id;
//	}
	
	//selectById
	public Optional<Genre> getGenreById(Integer id){
		return genreRepo.findById(id);
	}
	
	//insert
	public Genre insertGenre(Genre genre) {
		return genreRepo.save(genre);
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
		Genre genre = genreRepo.findById(id).get();
		
		genre.setGenre(newGenre.getGenre());
		genre.setDescription(newGenre.getDescription());
		
		return genreRepo.save(genre);
	}
	

}
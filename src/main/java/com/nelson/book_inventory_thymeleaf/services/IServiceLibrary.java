package com.nelson.book_inventory_thymeleaf.services;

public interface IServiceLibrary <T> extends IService<T>{
	
	T selectByTitle(String title);
	
	T selectByAuthor(Integer authorId);
	
	T selectByGenre(Integer genreId);
}

package com.nelson.book_inventory_thymeleaf.services;

import org.springframework.http.ResponseEntity;

public interface IService {
	
	<T> ResponseEntity<T> insert(T obj);

}

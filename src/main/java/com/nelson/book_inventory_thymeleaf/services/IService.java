package com.nelson.book_inventory_thymeleaf.services;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

public interface IService <T>{
	
	//insert - create
	ResponseEntity<T> insert(T obj);
	
	//Read - select *  
	ArrayList<T> select();
	
	//Read - select by id  
	T selectById(Integer id);
	
	//Update
	T updateById(T obj, Integer id);
	
	//Delete
	Boolean deleteById(Integer id);

}

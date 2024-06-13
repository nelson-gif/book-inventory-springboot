package com.nelson.book_inventory_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelson.book_inventory_thymeleaf.models.Book;

public interface IBookRepository extends JpaRepository<Book, Integer>{

}

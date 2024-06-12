package com.nelson.book_inventory_thymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelson.book_inventory_thymeleaf.models.Genre;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer>{

}

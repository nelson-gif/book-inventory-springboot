package com.nelson.book_inventory_thymeleaf.models;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookIsbn;
	@ManyToOne
	@JoinColumn(name="authorId")
	@JsonManagedReference
	private Author authorId;
    @ManyToOne
    @JoinColumn(name="genreId")
    @JsonManagedReference
	private Genre genreId;
	@Column
	private String title;
	@Column
	private Integer stock;
	@Column
	private Double price;
	@Column
	private Integer pages;
	@Column
	private Date publicationDate;



	public Book() {
	}

	public Book(Integer bookIsbn, Author authorId, Genre genreId, String title, Integer stock, Double price,
			Integer pages, Date publicationDate) {
		this.bookIsbn = bookIsbn;
		this.authorId = authorId;
		this.genreId = genreId;
		this.title = title;
		this.stock = stock;
		this.price = price;
		this.pages = pages;
		this.publicationDate = publicationDate;
	}

	public Integer getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(Integer bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public Genre getGenreId() {
		return genreId;
	}

	public void setGenreId(Genre genreId) {
		this.genreId = genreId;
	}

	public Author getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookIsbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(bookIsbn, other.bookIsbn);
	}

	
	
}

package com.nelson.book_inventory_thymeleaf.models;

import java.util.Date;

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
	private Integer bookISBN;
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author authorId;
	@ManyToOne
	@JoinColumn(name="genre_id")
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


	public Integer getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}

	public Author getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}

//	public Integer getGenre() {
//		return genreId;
//	}
//
//	public void setGenre(Integer genreId) {
//		this.genreId = genreId;
//	}

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

}

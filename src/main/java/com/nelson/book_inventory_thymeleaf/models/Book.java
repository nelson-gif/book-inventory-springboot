package com.nelson.book_inventory_thymeleaf.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	private Integer bookISBN;
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="authorId")
	private Author authorId;
	@ManyToOne(fetch=FetchType.LAZY)
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

	public Genre getGenre() {
		return genreId;
	}

	public void setGenre(Genre genreId) {
		this.genreId = genreId;
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
		return Objects.hash(bookISBN);
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
		return Objects.equals(bookISBN, other.bookISBN);
	}

	
}

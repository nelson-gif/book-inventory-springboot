package com.nelson.book_inventory_thymeleaf.models;

public class BookUser {

	private Integer userId;
	private Integer book_ISBN;

	public BookUser(Integer userId, Integer book_ISBN) {
		this.userId = userId;
		this.book_ISBN = book_ISBN;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBook_ISBN() {
		return book_ISBN;
	}

	public void setBook_ISBN(Integer book_ISBN) {
		this.book_ISBN = book_ISBN;
	}

}

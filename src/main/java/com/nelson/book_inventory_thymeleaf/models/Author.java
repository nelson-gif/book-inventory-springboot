package com.nelson.book_inventory_thymeleaf.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorId;
	@Column
	private String name;
	@Column
	private String lastName;
	@Column
	private String country;
	@Column
	private Gender gender;
	@Column
	private Date DOB;

	public Author(Integer authorId, String name, String lastName, String country, Gender gender, Date dOB) {
		this.authorId = authorId;
		this.name = name;
		this.lastName = lastName;
		this.country = country;
		this.gender = gender;
		DOB = dOB;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

}

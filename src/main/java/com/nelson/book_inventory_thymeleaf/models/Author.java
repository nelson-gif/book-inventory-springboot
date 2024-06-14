package com.nelson.book_inventory_thymeleaf.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
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
	@OneToMany( mappedBy = "authorId", cascade = CascadeType.ALL)
	List<Book> books1;
	//@JsonBackReference
	//@JsonIgnore

	public Author() {
	}

	public Author(Integer authorId, String name, String lastName, String country, Gender gender, Date dOB) {
		this.authorId = authorId;
		this.name = name;
		this.lastName = lastName;
		this.country = country;
		this.gender = gender;
		DOB = dOB;
	}

//	public List<Book> getBooks1() {
//		return books1;
//	}

	public void setBooks(List<Book> books) {
		this.books1 = books;
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

	@Override
	public int hashCode() {
		return Objects.hash(DOB, country, gender, lastName, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(DOB, other.DOB) && Objects.equals(country, other.country) && gender == other.gender
				&& Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}
	
	

}

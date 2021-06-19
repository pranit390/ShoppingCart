package com.shopping_cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book extends Product {

	@Column(name="book_genre")
	private String bookGenre;
	@Column(name="book_author")
	private String bookAuthor;
	@Column(name="book_publications")
	private String bookPublications;
	
	
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublications() {
		return bookPublications;
	}
	public void setBookPublications(String bookPublications) {
		this.bookPublications = bookPublications;
	}
	
	public Book() {
		
	}
	
	public Book(String productName, float productPrice, String bookGenre, String bookAuthor, String bookPublications) {
		super(productName, productPrice);
		this.bookGenre = bookGenre;
		this.bookAuthor = bookAuthor;
		this.bookPublications = bookPublications;
	}
	
}

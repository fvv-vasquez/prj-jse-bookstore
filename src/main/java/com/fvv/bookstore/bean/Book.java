package com.fvv.bookstore.bean;

/**
 * 
 * @author Fatima
 *
 */
public class Book {
	
	private String title;
	private Integer publicationYear;
	private Integer editionNumber;
	private String author;
	private Double price;
	private Integer isbn;
	private String publisher;
	private String genre;
	
	public Book(String title, Integer publicationYear, Integer editionNumber, String author, 
			Double price, Integer isbn, String publisher, String genre) {
		this.title = title;
		this.publicationYear = publicationYear;
		this.editionNumber = editionNumber;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
		this.publisher = publisher;
		this.genre = genre;
	}
	
	public Book() {
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Integer getPublicationYear() {
		return publicationYear;
	}

	public void setEditionNumber(Integer editionNumber) {
		this.editionNumber = editionNumber;
	}

	public Integer getEditionNumber() {
		return editionNumber;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public String toString() {
		return "Book Title: " + getTitle() + ", Publication Year: " + getPublicationYear() + 
				", Edition Number: " + getEditionNumber() + ", Author: " + getAuthor() + 
				", Price: " + getPrice() + ", ISBN: " + getIsbn() + ", Publisher: " + 
				getPublisher() + ", Genre: " + getGenre();
	}	
}

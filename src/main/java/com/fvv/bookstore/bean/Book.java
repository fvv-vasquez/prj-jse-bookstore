package com.fvv.bookstore.bean;

/**
 * Bean class for a Book object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
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
	
	/**
	 * Class constructor specifying the attributes
	 * @param title of the book
	 * @param publicationYear of the book
	 * @param editionNumber of the book
	 * @param author of the book
	 * @param price of the book
	 * @param isbn of the book
	 * @param publisher of the book
	 * @param genre of the book
	 */
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
	
	/**
	 * Class constructor
	 */
	public Book() {
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title of String type.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the last title.
	 * 
	 * @return the last title of String type.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the publication year.
	 * 
	 * @param publicationYear of Integer type.
	 */
	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * Gets the last publication year.
	 * 
	 * @return the last publicationYear of Integer type.
	 */
	public Integer getPublicationYear() {
		return this.publicationYear;
	}

	/**
	 * Sets the edition number.
	 * 
	 * @param editionNumber of Integer type.
	 */
	public void setEditionNumber(Integer editionNumber) {
		this.editionNumber = editionNumber;
	}

	/**
	 * Gets the last edition number.
	 * 
	 * @return the last editionNumber of Integer type.
	 */
	public Integer getEditionNumber() {
		return this.editionNumber;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author of String type.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Gets the last author.
	 * 
	 * @return the author title of String type.
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price of Double type.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the last price.
	 * 
	 * @return the last price of Double type.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Sets the isbn.
	 * 
	 * @param isbn of Integer type.
	 */
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the last isbn.
	 * 
	 * @return the last isbn of Integer type.
	 */
	public Integer getIsbn() {
		return this.isbn;
	}

	/**
	 * Sets the publisher.
	 * 
	 * @param publisher of String type.
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the last publisher.
	 * 
	 * @return the last publisher of String type.
	 */
	public String getPublisher() {
		return this.publisher;
	}

	/**
	 * Sets the genre.
	 * 
	 * @param genre of String type.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the last genre.
	 * 
	 * @return the last genre of String type.
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Book Title: " + getTitle() + ", Publication Year: " + getPublicationYear() + 
				", Edition Number: " + getEditionNumber() + ", Author: " + getAuthor() + 
				", Price: " + getPrice() + ", ISBN: " + getIsbn() + ", Publisher: " + 
				getPublisher() + ", Genre: " + getGenre();
	}	
}

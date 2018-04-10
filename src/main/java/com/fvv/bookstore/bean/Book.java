package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Bean class for a Book object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private Integer publicationYear;
	private Integer editionNumber;
	private String author;
	private Double price;
	private Integer isbn;
	private String publisher;
	private String genre;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param title of the book
	 * @param publicationYear of the book
	 * @param editionNumber of the book
	 * @param author of the book
	 * @param price of the book
	 * @param isbn of the book
	 * @param publisher of the book
	 * @param genre of the book
	 */
	public Book(final String title, final Integer publicationYear, final Integer editionNumber, 
			final String author, final Double price, final Integer isbn, final String publisher, 
			final String genre) {
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
	 * Sets the id.
	 * 
	 * @param id of Long type.
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id of Long type.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title of String type.
	 */
	public void setTitle(final String title) {
		this.title = title;
	}
	
	/**
	 * Gets the title.
	 * 
	 * @return the title of String type.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the publication year.
	 * 
	 * @param publicationYear of Integer type.
	 */
	public void setPublicationYear(final Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	/**
	 * Gets the publication year.
	 * 
	 * @return the publicationYear of Integer type.
	 */
	public Integer getPublicationYear() {
		return this.publicationYear;
	}

	/**
	 * Sets the edition number.
	 * 
	 * @param editionNumber of Integer type.
	 */
	public void setEditionNumber(final Integer editionNumber) {
		this.editionNumber = editionNumber;
	}

	/**
	 * Gets the edition number.
	 * 
	 * @return the editionNumber of Integer type.
	 */
	public Integer getEditionNumber() {
		return this.editionNumber;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author of String type.
	 */
	public void setAuthor(final String author) {
		this.author = author;
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author of String type.
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price of Double type.
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price of Double type.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Sets the isbn.
	 * 
	 * @param isbn of Integer type.
	 */
	public void setIsbn(final Integer isbn) {
		this.isbn = isbn;
	}

	/**
	 * Gets the isbn.
	 * 
	 * @return the isbn of Integer type.
	 */
	public Integer getIsbn() {
		return this.isbn;
	}

	/**
	 * Sets the publisher.
	 * 
	 * @param publisher of String type.
	 */
	public void setPublisher(final String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Gets the publisher.
	 * 
	 * @return the publisher of String type.
	 */
	public String getPublisher() {
		return this.publisher;
	}

	/**
	 * Sets the genre.
	 * 
	 * @param genre of String type.
	 */
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the genre.
	 * 
	 * @return the genre of String type.
	 */
	public String getGenre() {
		return this.genre;
	}	
	
	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate of Date type.
	 */
	public void setModificationDate(final Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modificationDate of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book ID: " + getId() + " - Title: " + getTitle() + ", Publication Year: " + 
				getPublicationYear() + ", Author: " + getAuthor() + ", Price: " + getPrice();
	}	
}

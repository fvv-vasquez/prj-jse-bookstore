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
public class Book extends Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String title;
	private Integer publicationYear;
	private Integer editionNumber;
	private String author;
	private Integer isbn;
	private String publisher;
	private String genre;
	
	
	/**
	 * Class constructor specifying the attributes  and with super from the Class Product
	 * 
	 * @param id of the Book
	 * @param unitPrice of the Book
	 * @param stockQty of the Book
	 * @param modificationDate of the Book
	 * @param title of the Book
	 * @param publicationYear of the Book
	 * @param editionNumber of the Book
	 * @param author of the Book
	 * @param isbn of the Book
	 * @param publisher of the Book
	 * @param genre of the Book
	 */
	public Book(final Long id, final Double unitPrice, final Integer stockQty, final Date 
			modificationDate, final String title, final Integer publicationYear, final Integer 
			editionNumber, final String author, final Integer isbn, final String publisher,
			final String genre) {
		super(id, unitPrice, stockQty, modificationDate);
		this.title = title;
		this.publicationYear = publicationYear;
		this.editionNumber = editionNumber;
		this.author = author;
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
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book ID: " + getId() + " - Title: " + getTitle() + ", Author: " + getAuthor() + 
				", Unit Price: " + getUnitPrice() + ", Stock Quantity: " + getStockQty();
	}	
}

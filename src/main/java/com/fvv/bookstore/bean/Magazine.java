package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * Create on 03/30/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class Magazine {
	
	private String name;
	private Integer editionNumber;
	private String genre;
	private Date publicationDate;
	private String publisher;
	private Double price;
	
	/**
	 * Class constructor specifying the attributes
	 */
	public Magazine(String name, Integer editionNumber, String genre, Date publicationDate, 
			String publisher, Double price) {
		this.name = name;
		this.editionNumber = editionNumber;
		this.genre = genre;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.price = price;
	}
	
	/**
	 * Class constructor
	 */
	public Magazine() {
	}

	/**
	 * Sets the name.
	 * 
	 * @param name of String type.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name of String type.
	 */
	public String getName() {
		return this.name;
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
	 * Sets the publication date.
	 * 
	 * @param publicationDate of Date type.
	 */
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets the last publication date.
	 * 
	 * @return the last publicationDate of Date type.
	 */
	public Date getPublicationDate() {
		return this.publicationDate;
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Magazine Name: " + getName() + ", Edition Number: " + getEditionNumber() + 
				", Genre: " + getGenre() + ", Publication Date: " + getPublicationDate() +
				", Publisher: " + getPublisher() + ", Price: " + getPrice();
	}
}

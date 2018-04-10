package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

import com.fvv.bookstore.util.DateUtil;

/**
 * Bean class for a Magazine object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class Magazine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Integer editionNumber;
	private String genre;
	private Date publicationDate;
	private String publisher;
	private Double price;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param name of the magazine
	 * @param editionNumber of the magazine
	 * @param genre of the magazine
	 * @param publicationDate of the magazine
	 * @param publisher of the magazine
	 * @param price of the magazine
	 */
	public Magazine(final String name, final Integer editionNumber, final String genre, 
			final Date publicationDate, final String publisher, final Double price) {
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
	 * Sets the name.
	 * 
	 * @param name of String type.
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name of String type.
	 */
	public String getName() {
		return this.name;
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
	 * Sets the publication date.
	 * 
	 * @param publicationDate of Date type.
	 */
	public void setPublicationDate(final Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets the publication date.
	 * 
	 * @return the publicationDate of Date type.
	 */
	public Date getPublicationDate() {
		return this.publicationDate;
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
	 * @return the modification date of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Magazine ID: " + getId() + " - Name: " + getName() + ", Edition Number: " + 
				getEditionNumber() + ", Publication Date: " + 
				DateUtil.dateToString(getPublicationDate()) + ", Price: " + getPrice();
	}
}

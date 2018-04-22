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
public class Magazine extends Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer editionNumber;
	private String genre;
	private Date publicationDate;
	private String publisher;
	
	/**
	 * Class constructor specifying the attributes  and with super from the Class Product
	 * 
	 * @param id of the Magazine
	 * @param unitPrice of the Magazine
	 * @param stockQty of the Magazine
	 * @param modificationDate of the Magazine
	 * @param name of the Magazine
	 * @param editionNumber of the Magazine
	 * @param genre of the Magazine
	 * @param publicationDate of the Magazine
	 * @param publisher of the Magazine
	 */ 
	public Magazine(final Long id, final Double unitPrice, final Integer stockQty, final Date 
			modificationDate, final String name, final Integer editionNumber, final String genre, 
			final Date publicationDate, final String publisher) {
		super(id, unitPrice, stockQty, modificationDate);
		this.name = name;
		this.editionNumber = editionNumber;
		this.genre = genre;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
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
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Magazine)) {
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
		return "Magazine ID: " + getId() + " - Name: " + getName() + ", Publication Date: " + 
				DateUtil.dateToString(getPublicationDate()) + ", Unit Price: " + getUnitPrice() +
				", Stock Quantity: " + getStockQty();
	}
}

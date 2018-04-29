package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Bean class for a MovieDvd object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class MovieDvd extends Dvd implements Serializable {

	private static final long serialVersionUID = 1L;
	private String director;

	/**
	 * Class constructor specifying the attributes and with super from the Class Dvd
	 * 
	 * @param id of the Movie DVD
	 * @param unitPrice of the Movie DVD
	 * @param stockQty of the Movie DVD
	 * @param modificationDate of the Movie DVD
	 * @param title of the Movie DVD
	 * @param totalDuration of the Movie DVD
	 * @param genre of the Movie DVD
	 * @param releaseYear of the Movie DVD
	 * @param code of the Movie DVD
	 * @param director of the Movie DVD
	 */
	public MovieDvd(final Long id, final Double unitPrice, final Integer stockQty, final Date 
			modificationDate, final String title, final Integer totalDuration, final String genre, 
			final Integer releaseYear, final Integer code, final String director) {
		super(id, unitPrice, stockQty, modificationDate, title, totalDuration, genre, releaseYear, 
				code);
		this.director = director;
	}

	/**
	 * Class constructor
	 */
	public MovieDvd() {
	}

	/**
	 * Sets the director.
	 * 
	 * @param director of String type.
	 */
	public void setDirector(final String director) {
		this.director = director;
	}

	/**
	 * Gets the director.
	 * 
	 * @return the director of String type.
	 */
	public String getDirector() {
		return this.director;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MovieDvd)) {
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
		return "Movie DVD ID: " + getId() + " - Title: " + getTitle() + ", Genre: " + getGenre() + 
				", Director: " + getDirector() + ", Unit Price: " + getUnitPrice() + 
				", Stock Quantity: " + getStockQty();
	}
}

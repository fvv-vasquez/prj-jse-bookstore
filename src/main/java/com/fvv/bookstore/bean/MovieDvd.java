package com.fvv.bookstore.bean;

import java.io.Serializable;

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
	 * @param title of the Movie DVD
	 * @param totalDuration of the Movie DVD
	 * @param price of the Movie DVD
	 * @param genre of the Movie DVD
	 * @param releaseYear of the Movie DVD
	 * @param code of the Movie DVD
	 * @param director of the Movie DVD
	 */
	public MovieDvd(final String title, final Integer totalDuration, final Double price, 
			final String genre, final Integer releaseYear, final Integer code, 
			final String director) {
		super(title, totalDuration, price, genre, releaseYear, code);
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
	 * Gets the last director.
	 * 
	 * @return the last director of String type.
	 */
	public String getDirector() {
		return this.director;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Movie DVD ID: " + getId() + " - Title: " + getTitle() + ", Price: " + getPrice() +
				", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() + 
				", Director: " + getDirector();	
	}
}

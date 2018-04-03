package com.fvv.bookstore.bean;

import java.io.Serializable;

/**
 * Bean class for a ShowDvd object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class ShowDvd extends Dvd implements Serializable {

	private static final long serialVersionUID = 1L;
	private String artist;

	/**
	 * Class constructor specifying the attributes and with super from the Class Dvd
	 * @param title of the Movie DVD
	 * @param totalDuration of the Movie DVD
	 * @param price of the Movie DVD
	 * @param genre of the Movie DVD
	 * @param releaseYear of the Movie DVD
	 * @param code of the Movie DVD
	 * @param artist of the Movie DVD
	 */
	public ShowDvd(final String title, final Integer totalDuration, final Double price, 
			final String genre, final Integer releaseYear, final Integer code, 
			final String artist) {
		super(title, totalDuration, price, genre, releaseYear, code);
		this.artist = artist;
	}

	/**
	 * Class constructor
	 */
	public ShowDvd() {
	}

	/**
	 * Sets the artist.
	 * 
	 * @param artist of String type.
	 */
	public void setArtist(final String artist) {
		this.artist = artist;
	}

	/**
	 * Gets the last artist.
	 * 
	 * @return the last artist of String type.
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Show DVD ID: " + getId() + " - Title: " + getTitle() + ", Price: " + getPrice() + 
				", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() + 
				", Artist: " + getArtist();	
	}
}

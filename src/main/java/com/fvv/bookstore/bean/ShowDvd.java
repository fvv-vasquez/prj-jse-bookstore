package com.fvv.bookstore.bean;

/**
 * Bean class for a ShowDvd object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class ShowDvd extends Dvd {
	
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
	public ShowDvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code, String artist) {
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
	public void setArtist(String artist) {
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
	public String toString() {
		return "Show DVD ID: " + getId() + ", Title: " + getTitle() + ", Total Duration: " + 
				getTotalDuration() + ", Price: " + getPrice() + ", Genre: " + getGenre() + 
				", Release Year: " + getReleaseYear() + ", Code: " + getCode() + ", Artist: " 
				+ getArtist();	
	}
}

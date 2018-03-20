package com.fvv.bookstore.bean;

/**
 * Create on 03/30/2018
 * @author Fatima Vasquez
 * @version 1.0 
 */
public class ShowDvd extends Dvd {
	
	private String artist;

	/**
	 * Class constructor specifying the attributes and with super from the Class Dvd
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
		return "DVD Title: " + getTitle() + ", Total Duration: " + getTotalDuration() + "Price: "
				+ getPrice() + ", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() 
				+ ", Code: " + getCode() + ", Artist: " + getArtist();	
	}
}

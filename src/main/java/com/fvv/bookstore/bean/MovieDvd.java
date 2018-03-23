package com.fvv.bookstore.bean;

/**
 * Bean class for a MovieDvd object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class MovieDvd extends Dvd {
	
	private String director;

	/**
	 * Class constructor specifying the attributes and with super from the Class Dvd
	 */
	public MovieDvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code, String director) {
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
	public void setDirector(String director) {
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
	public String toString() {
		return "DVD Title: " + getTitle() + ", Total Duration: " + getTotalDuration() + "Price: "
				+ getPrice() + ", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() 
				+ ", Code: " + getCode() + ", Director: " + getDirector();	
	}
}

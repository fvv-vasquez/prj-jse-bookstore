package com.fvv.bookstore.bean;

/**
 * 
 * @author Fatima
 *
 */
public class MovieDvd extends Dvd {
	
	private String director;

	public MovieDvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code, String director) {
		super(title, totalDuration, price, genre, releaseYear, code);
		this.director = director;
	}

	public MovieDvd() {
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDirector() {
		return director;
	}
	
	public String toString() {
		return "DVD Title: " + getTitle() + ", Total Duration: " + getTotalDuration() + "Price: "
				+ getPrice() + ", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() 
				+ ", Code: " + getCode() + ", Director: " + getDirector();	
	}
}

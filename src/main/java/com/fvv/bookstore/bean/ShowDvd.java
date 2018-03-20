package com.fvv.bookstore.bean;

/**
 * 
 * @author Fatima
 *
 */
public class ShowDvd extends Dvd {
	
	private String artist;

	public ShowDvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code, String artist) {
		super(title, totalDuration, price, genre, releaseYear, code);
		this.artist = artist;
	}

	public ShowDvd() {
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}
	
	public String toString() {
		return "DVD Title: " + getTitle() + ", Total Duration: " + getTotalDuration() + "Price: "
				+ getPrice() + ", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() 
				+ ", Code: " + getCode() + ", Artist: " + getArtist();	
	}
}

package com.fvv.bookstore.bean;

/**
 * 
 * @author Fatima
 *
 */
public abstract class Dvd {
	
	private String title;
	private Integer totalDuration;
	private Double price;
	private String genre;
	private Integer releaseYear;
	private Integer code;
	
	public Dvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code) {
		this.title = title;
		this.totalDuration = totalDuration;
		this.price = price;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.code = code;
	}
	
	public Dvd() {
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTotalDuration(Integer totalDuration) {
		this.totalDuration = totalDuration;
	}

	public Integer getTotalDuration() {
		return totalDuration;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
	
	public String toString() {
		return "DVD Title: " + getTitle() + ", Total Duration: " + getTotalDuration() + "Price: "
				+ getPrice() + ", Genre: " + getGenre() + ", Release Year: " + getReleaseYear() 
				+ ", Code: " + getCode();	
	}
}

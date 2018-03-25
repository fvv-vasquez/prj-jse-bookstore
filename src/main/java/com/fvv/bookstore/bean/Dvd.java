package com.fvv.bookstore.bean;

/**
 * Bean abstract class for a Dvd object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public abstract class Dvd {
	
	private Long id;
	private String title;
	private Integer totalDuration;
	private Double price;
	private String genre;
	private Integer releaseYear;
	private Integer code;
	
	/**
	 * Class constructor specifying the attributes
	 * @param title of the DVD
	 * @param totalDuration of the DVD
	 * @param price of the DVD
	 * @param genre of the DVD
	 * @param releaseYear of the DVD
	 * @param code of the DVD
	 */
	public Dvd(String title, Integer totalDuration, Double price, String genre, 
			Integer releaseYear, Integer code) {
		this.title = title;
		this.totalDuration = totalDuration;
		this.price = price;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.code = code;
	}
	
	/**
	 * Class constructor
	 */
	public Dvd() {
	}

	/**
	 * Sets the id.
	 * 
	 * @param id of Long type.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the last id.
	 * 
	 * @return the last id of Long type.
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title of String type.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the last title.
	 * 
	 * @return the last title of String type.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the total duration of the DVD.
	 * 
	 * @param totalDuration of Integer type.
	 */
	public void setTotalDuration(Integer totalDuration) {
		this.totalDuration = totalDuration;
	}

	/**
	 * Gets the last total duration.
	 * 
	 * @return the last totalDuration of Integer type.
	 */
	public Integer getTotalDuration() {
		return this.totalDuration;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price of Double type.
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Gets the last price.
	 * 
	 * @return the last price of Double type.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Sets the genre.
	 * 
	 * @param genre of String type.
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the last genre.
	 * 
	 * @return the last genre of String type.
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * Sets the release year.
	 * 
	 * @param releaseYear of Integer type.
	 */
	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * Gets the last release year.
	 * 
	 * @return the last releaseYear of Integer type.
	 */
	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code of Integer type.
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Gets the last code.
	 * 
	 * @return the last code of Integer type.
	 */
	public Integer getCode() {
		return this.code;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "DVD ID: " + getId() + ", Title: " + getTitle() + ", Total Duration: " + 
				getTotalDuration() + ", Price: " + getPrice() + ", Genre: " + getGenre() + 
				", Release Year: " + getReleaseYear() + ", Code: " + getCode();	
	}
}

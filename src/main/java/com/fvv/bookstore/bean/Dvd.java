package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * Bean abstract class for a Dvd object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public abstract class Dvd {
	
	private Long id;
	private String title;
	private Integer totalDuration;
	private Double price;
	private String genre;
	private Integer releaseYear;
	private Integer code;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * 
	 * @param title of the DVD
	 * @param totalDuration of the DVD
	 * @param price of the DVD
	 * @param genre of the DVD
	 * @param releaseYear of the DVD
	 * @param code of the DVD
	 */
	public Dvd(final String title, final Integer totalDuration, final Double price, 
			final String genre, final Integer releaseYear, final Integer code) {
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
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id of Long type.
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title of String type.
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title of String type.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the total duration of the DVD.
	 * 
	 * @param totalDuration of Integer type.
	 */
	public void setTotalDuration(final Integer totalDuration) {
		this.totalDuration = totalDuration;
	}

	/**
	 * Gets the total duration.
	 * 
	 * @return the totalDuration of Integer type.
	 */
	public Integer getTotalDuration() {
		return this.totalDuration;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price of Double type.
	 */
	public void setPrice(final Double price) {
		this.price = price;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price of Double type.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Sets the genre.
	 * 
	 * @param genre of String type.
	 */
	public void setGenre(final String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the genre.
	 * 
	 * @return the genre of String type.
	 */
	public String getGenre() {
		return this.genre;
	}

	/**
	 * Sets the release year.
	 * 
	 * @param releaseYear of Integer type.
	 */
	public void setReleaseYear(final Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * Gets the release year.
	 * 
	 * @return the releaseYear of Integer type.
	 */
	public Integer getReleaseYear() {
		return this.releaseYear;
	}

	/**
	 * Sets the code.
	 * 
	 * @param code of Integer type.
	 */
	public void setCode(final Integer code) {
		this.code = code;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code of Integer type.
	 */
	public Integer getCode() {
		return this.code;
	}
	
	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate of Date type.
	 */
	public void setModificationDate(final Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modificationDate of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DVD ID: " + getId() + " - Title: " + getTitle() + ", Price: " + getPrice() + 
				", Genre: " + getGenre() + ", Release Year: " + getReleaseYear();	
	}
}

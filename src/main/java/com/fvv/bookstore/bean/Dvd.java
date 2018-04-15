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
public abstract class Dvd extends Product {
	
	private String title;
	private Integer totalDuration;
	private String genre;
	private Integer releaseYear;
	private Integer code;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Product
	 * 
	 * @param id of the DVD
	 * @param unitPrice of the DVD
	 * @param stockQty of the DVD
	 * @param modificationDate of the DVD
	 * @param title of the DVD
	 * @param totalDuration of the DVD
	 * @param genre of the DVD
	 * @param releaseYear of the DVD
	 * @param code of the DVD
	 */
	public Dvd(final Long id, final Double unitPrice, final Integer stockQty, final Date 
			modificationDate, final String title, final Integer totalDuration, final String genre, 
			final Integer releaseYear, final Integer code) {
		super(id, unitPrice, stockQty, modificationDate);
		this.title = title;
		this.totalDuration = totalDuration;
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
}

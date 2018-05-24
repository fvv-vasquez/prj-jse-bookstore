package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

import com.fvv.bookstore.util.MathUtil;

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
	 * 
	 * @param id of the Show DVD
	 * @param unitPrice of the Show DVD
	 * @param stockQty of the Show DVD
	 * @param modificationDate of the Show DVD
	 * @param title of the Show DVD
	 * @param totalDuration of the Show DVD
	 * @param genre of the Show DVD
	 * @param releaseYear of the Show DVD
	 * @param code of the Show DVD
	 * @param artist of the Show DVD
	 */
	public ShowDvd(Long id, Double unitPrice, Integer stockQty, Date modificationDate, String title,
			Integer totalDuration, String genre, Integer releaseYear, Integer code, String artist) {
		super(id, unitPrice, stockQty, modificationDate, title, totalDuration, genre, releaseYear, code);
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
	 * Gets the artist.
	 * 
	 * @return the artist of String type.
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ShowDvd)) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		}
		return true;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Show DVD ID: " + getId() + " - Title: " + getTitle() + ", Genre: " + getGenre() + ", Artist: " + getArtist() 
				+ ", Unit Price: " + MathUtil.formatNumbers(getUnitPrice()) + ", Stock Quantity: " + getStockQty();
	}
}

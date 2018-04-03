package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * Bean abstract class for a Hardware object 
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public abstract class Hardware {
	
	private Long id;
	private String brand;
	private Double price;
	private Integer warranty;
	private Date modificationDate;
	
	/**
	 * Class constructor specifying the attributes
	 * @param brand of the Hardware
	 * @param price of the Hardware
	 * @param warranty of the Hardware
	 */
	public Hardware(final String brand, final Double price, final Integer warranty) {
		this.brand = brand;
		this.price = price;
		this.warranty = warranty;
	}

	/**
	 * Class constructor
	 */
	public Hardware() {
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
	 * Gets the last id.
	 * 
	 * @return the last id of Long type.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the brand.
	 * 
	 * @param brand of String type.
	 */
	public void setBrand(final String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the last brand.
	 * 
	 * @return the last brand of String type.
	 */
	public String getBrand() {
		return this.brand;
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
	 * Gets the last price.
	 * 
	 * @return the last price of Double type.
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * Sets the warranty.
	 * 
	 * @param warranty of Integer type.
	 */
	public void setWarranty(final Integer warranty) {
		this.warranty = warranty;
	}

	/**
	 * Gets the last warranty.
	 * 
	 * @return the last warranty of Integer type.
	 */
	public Integer getWarranty() {
		return this.warranty;
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
	 * Gets the last modification date.
	 * 
	 * @return the last modification date of Date type.
	 */
	public Date getModificationDate() {
		return this.modificationDate;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ID: " + getId() + " - Brand: " + getBrand() + ", Price: " + getPrice() + 
				", Warranty: " + getWarranty();
	}
}

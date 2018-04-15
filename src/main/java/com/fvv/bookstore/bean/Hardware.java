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
public abstract class Hardware extends Product {
	
	private String brand;
	private Integer warranty;
	

	/**
	 * Class constructor specifying the attributes and with super from the Class Product
	 * 
	 * @param id of the Hardware
	 * @param unitPrice of the Hardware
	 * @param stockQty of the Hardware
	 * @param modificationDate of the Hardware
	 * @param brand of the Hardware
	 * @param warranty of the Hardware
	 */
	public Hardware(final Long id, final Double unitPrice, final Integer stockQty,
			final Date modificationDate, final String brand, final Integer warranty) {
		super(id, unitPrice, stockQty, modificationDate);
		this.brand = brand;
		this.warranty = warranty;
	}

	/**
	 * Class constructor
	 */
	public Hardware() {
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
	 * Gets the brand.
	 * 
	 * @return the brand of String type.
	 */
	public String getBrand() {
		return this.brand;
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
	 * Gets the warranty.
	 * 
	 * @return the warranty of Integer type.
	 */
	public Integer getWarranty() {
		return this.warranty;
	}
}

package com.fvv.bookstore.bean;

import java.io.Serializable;

/**
 * Bean class for a Cellphone object 
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class Cellphone extends Hardware implements Serializable {

	private static final long serialVersionUID = 1L;	
	private Integer storageMemory;
	private Integer camPixels;
		
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 * @param brand of the Cellphone
	 * @param price of the Cellphone
	 * @param warranty of the Cellphone
	 * @param storageMemory of the Cellphone
	 * @param camPixels of the Cellphone
	 */
	public Cellphone(final String brand, final Double price, final Integer warranty, 
			final Integer storageMemory, final Integer camPixels) {
		super(brand, price, warranty);
		this.storageMemory = storageMemory;
		this.camPixels = camPixels;
	}

	/**
	 * Class constructor
	 */
	public Cellphone() {
	}

	/**
	 * Sets the storage memory.
	 * 
	 * @param storageMemory of Integer type.
	 */
	public void setStorageMemory(final Integer storageMemory) {
		this.storageMemory = storageMemory;
	}

	/**
	 * Gets the last storage memory.
	 * 
	 * @return the last storageMemory of Integer type.
	 */
	public Integer getStorageMemory() {
		return this.storageMemory;
	}

	/**
	 * Sets the camPixels.
	 * 
	 * @param camPixels of Integer type.
	 */
	public void setCamPixels(final Integer camPixels) {
		this.camPixels = camPixels;
	}

	/**
	 * Gets the last camPixels.
	 * 
	 * @return the last camPixels of Integer type.
	 */
	public Integer getCamPixels() {
		return this.camPixels;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cellphone ID: " + getId() + " - Brand: " + getBrand() + ", Price: " + getPrice() + 
				", Warranty: " + getWarranty() + " months, Storage Memory: " + getStorageMemory() 
				+ "GB";
	}
}

package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

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
	 * 
	 * @param id of the Cellphone
	 * @param unitPrice of the Cellphone
	 * @param stockQty of the Cellphone
	 * @param modificationDate of the Cellphone
	 * @param brand of the Cellphone
	 * @param warranty of the Cellphone
	 * @param storageMemory of the Cellphone
	 * @param camPixels of the Cellphone
	 */
	public Cellphone(final Long id, final Double unitPrice, final Integer stockQty, 
			final Date modificationDate, final String brand, final Integer warranty, 
			final Integer storageMemory, final Integer camPixels) {
		super(id, unitPrice, stockQty, modificationDate, brand, warranty);
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
	 * Gets the storage memory.
	 * 
	 * @return the storageMemory of Integer type.
	 */
	public Integer getStorageMemory() {
		return this.storageMemory;
	}

	/**
	 * Sets the pixels of the camera.
	 * 
	 * @param camPixels of Integer type.
	 */
	public void setCamPixels(final Integer camPixels) {
		this.camPixels = camPixels;
	}

	/**
	 * Gets the pixels of the camera.
	 * 
	 * @return the camPixels of Integer type.
	 */
	public Integer getCamPixels() {
		return this.camPixels;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cellphone ID: " + getId() + " - Brand: " + getBrand() + ", Warranty: " + 
				getWarranty() + " months, Storage Memory: " + getStorageMemory() +
				" GB, Unit Price: " + getUnitPrice() + ", Stock Quantity: " + getStockQty();
	}
}

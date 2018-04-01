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
	private Double screenSize;
	private Integer storageMemory;
	private Integer camera;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 * @param brand of the Cellphone
	 * @param model of the Cellphone
	 * @param color of the Cellphone
	 * @param price of the Cellphone
	 * @param warranty of the Cellphone
	 * @param screenSize of the Cellphone
	 * @param storageMemory of the Cellphone
	 * @param camera of the Cellphone
	 */
	public Cellphone(final String brand, final String model, final String color, final Double 
			price, final Integer warranty, final Double screenSize, final Integer storageMemory, 
			final Integer camera) {
		super(brand, model, color, price, warranty);
		this.screenSize = screenSize;
		this.storageMemory = storageMemory;
		this.camera = camera;
	}
	
	/**
	 * Class constructor
	 */
	public Cellphone() {
	}

	/**
	 * Sets the screen size.
	 * 
	 * @param screenSize of Double type.
	 */
	public void setScreenSize(final Double screenSize) {
		this.screenSize = screenSize;
	}

	/**
	 * Gets the last screen size.
	 * 
	 * @return the last screenSize of Double type.
	 */
	public Double getScreenSize() {
		return this.screenSize;
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
	 * Sets the camera.
	 * 
	 * @param camera of Integer type.
	 */
	public void setCamera(final Integer camera) {
		this.camera = camera;
	}

	/**
	 * Gets the last camera.
	 * 
	 * @return the last camera of Integer type.
	 */
	public Integer getCamera() {
		return this.camera;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Cellphone ID: " + getId() + " - Brand: " + getBrand() + ", Price: " + getPrice() + 
				", Warranty: " + getWarranty() + ", Screen Size: " + getScreenSize();
	}
}

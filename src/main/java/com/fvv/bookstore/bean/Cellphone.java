package com.fvv.bookstore.bean;

/**
 * Bean class for a Cellphone object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class Cellphone extends Hardware {

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
	public Cellphone(String brand, String model, String color, Double price, 
			Integer warranty, Double screenSize, Integer storageMemory, Integer camera) {
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
	public void setScreenSize(Double screenSize) {
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
	public void setStorageMemory(Integer storageMemory) {
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
	public void setCamera(Integer camera) {
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
		return "Cellphone ID: " + getId() + ", Brand: " + getBrand() + ", Model: " + getModel() 
				+ ", Color: " + getColor() + ", Price: " + getPrice() + ", Warranty: " + 
				getWarranty() + ", Date: " + getDate() + ", Screen Size: " + getScreenSize() + 
				", Storage Memory: " + getStorageMemory() + ", Camera: " + getCamera();
	}
}

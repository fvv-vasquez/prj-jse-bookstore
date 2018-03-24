package com.fvv.bookstore.bean;

/**
 * Bean class for a Mouse object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class Mouse extends Hardware {
	
	private String connection;
	private Long resolution;
	private Boolean wired;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 * @param id of the Mouse
	 * @param brand of the Mouse
	 * @param model of the Mouse
	 * @param color of the Mouse
	 * @param price of the Mouse
	 * @param warranty of the Mouse
	 * @param connection of the Mouse
	 * @param resolution of the Mouse
	 * @param wired of the Mouse
	 */
	public Mouse(Integer id, String brand, String model, String color, Double price, 
			Integer warranty, String connection, Long resolution, Boolean wired) {
		super(id, brand, model, color, price, warranty);
		this.connection = connection;
		this.resolution = resolution;
		this.wired = wired;
	}
	
	/**
	 * Class constructor
	 */
	public Mouse() {
	}

	/**
	 * Sets the connection.
	 * 
	 * @param connection of String type.
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}

	/**
	 * Gets the last connection.
	 * 
	 * @return the last connection of String type.
	 */
	public String getConnection() {
		return this.connection;
	}

	/**
	 * Sets the resolution.
	 * 
	 * @param resolution of Long type.
	 */
	public void setResolution(Long resolution) {
		this.resolution = resolution;
	}

	/**
	 * Gets the last connection.
	 * 
	 * @return the last connection of String type.
	 */
	public Long getResolution() {
		return this.resolution;
	}

	/**
	 * Sets the wired.
	 * 
	 * @param wired of Boolean type.
	 */
	public void setWired(Boolean wired) {
		this.wired = wired;
	}

	/**
	 * Gets the last information if is wired.
	 * 
	 * @return the last wired information of Boolean type.
	 */
	public Boolean isWired() {
		return this.wired;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ID: " + getId() + ", Brand: " + getBrand() + ", Model: " + getModel() + 
				", Color: " + getColor() + ", Price: " + getPrice() + ", Warranty: " + 
				getWarranty() + ", Connection: " + getConnection() + ", Resolution (dpi): " +
				getResolution() + ", Wired: " + isWired();
	}
}

package com.fvv.bookstore.bean;

/**
 * Create on 03/30/2018
 * @author Fatima Vasquez
 * @version 1.0 
 */
public class Keyboard extends Hardware {

	private String connection;
	private Boolean multimedia;
	private Boolean wired;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 */
	public Keyboard(Integer id, String brand, String model, String color, Double price, 
			Integer warranty, String connection, Boolean multimedia, Boolean wired) {
		super(id, brand, model, color, price, warranty);
		this.connection = connection;
		this.multimedia = multimedia;
		this.wired = wired;
	}
	
	/**
	 * Class constructor
	 */
	public Keyboard() {
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
	 * Sets the multimedia.
	 * 
	 * @param multimedia of Boolean type.
	 */
	public void setMultimedia(Boolean multimedia) {
		this.multimedia = multimedia;
	}

	/**
	 * Gets the last information if has multimedia.
	 * 
	 * @return the last multimedia information of Boolean type.
	 */
	public Boolean hasMultimedia() {
		return this.multimedia;
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
				getWarranty() + ", Connection: " + getConnection() + ", Multimedia: " +
				hasMultimedia() + ", Wired: " + isWired();
	}	
}

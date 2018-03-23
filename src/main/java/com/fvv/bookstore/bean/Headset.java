package com.fvv.bookstore.bean;

/**
 * Bean class for a Headset object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class Headset extends Hardware {
	
	private String connection;
	private Boolean microphone;
	private Boolean wired;

	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 */
	public Headset(Integer id, String brand, String model, String color, Double price, 
			Integer warranty, String connection, Boolean microphone, Boolean wired) {
		super(id, brand, model, color, price, warranty);
		this.connection = connection;
		this.microphone = microphone;
		this.wired = wired;
	}

	/**
	 * Class constructor
	 */
	public Headset() {
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
	 * Sets the microphone.
	 * 
	 * @param microphone of Boolean type.
	 */
	public void setMicrophone(Boolean microphone) {
		this.microphone = microphone;
	}

	/**
	 * Gets the last information if has microphone.
	 * 
	 * @return the last microphone information of Boolean type.
	 */
	public Boolean hasMicrophone() {
		return this.microphone;
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
				getWarranty() + ", Connection: " + getConnection() + ", Microphone: " +
				hasMicrophone() + ", Wired: " + isWired();
	}
}

package com.fvv.bookstore.bean;

/**
 * Bean abstract class for a Hardware object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public abstract class Hardware {
	
	private Integer id;
	private String brand;
	private String model;
	private String color;
	private Double price;
	private Integer warranty;
	
	/**
	 * Class constructor specifying the attributes
	 */
	public Hardware(Integer id, String brand, String model, String color, 
			Double price, Integer warranty) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
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
	 * @param id of Integer type.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the last id.
	 * 
	 * @return the last id of Integer type.
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the brand.
	 * 
	 * @param brand of String type.
	 */
	public void setBrand(String brand) {
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
	 * Sets the model.
	 * 
	 * @param model of String type.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the last model.
	 * 
	 * @return the last model of String type.
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Sets the color.
	 * 
	 * @param color of String type.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the last color.
	 * 
	 * @return the last color of String type.
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price of Double type.
	 */
	public void setPrice(Double price) {
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
	public void setWarranty(Integer warranty) {
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ID: " + getId() + ", Brand: " + getBrand() + ", Model: " + getModel() + 
				", Color: " + getColor() + ", Price: " + getPrice() + ", Warranty: " + 
				getWarranty();
	}
}

package com.fvv.bookstore.bean;

/**
 * Create on 03/30/2018
 * @author Fatima Vasquez
 * @version 1.0 
 */
public class Laptop extends Hardware {

	private Integer ramSize;
	private String processor;
	private Double screenSize;
	private Double hdSize;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 */
	public Laptop(Integer id, String brand, String model, String color, Double price, Integer 
			warranty, Integer ramSize, String processor, Double screenSize, Double hdSize) {
		super(id, brand, model, color, price, warranty);
		this.ramSize = ramSize;
		this.processor = processor;
		this.screenSize = screenSize;
		this.hdSize = hdSize;
	}
	
	/**
	 * Class constructor
	 */
	public Laptop() {
	}

	/**
	 * Sets the RAM size in GB.
	 * 
	 * @param ramSize of Integer type.
	 */
	public void setRamSize(Integer ramSize) {
		this.ramSize = ramSize;
	}

	/**
	 * Gets the last RAM size in GB.
	 * 
	 * @return the last ramSize of Integer type.
	 */
	public Integer getRamSize() {
		return this.ramSize;
	}

	/**
	 * Sets the processor.
	 * 
	 * @param processor of String type.
	 */
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	/**
	 * Gets the last processor.
	 * 
	 * @return the last processor of String type.
	 */
	public String getProcessor() {
		return this.processor;
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
	 * Sets the HD size.
	 * 
	 * @param hdSize of Double type.
	 */
	public void setHdSize(Double hdSize) {
		this.hdSize = hdSize;
	}

	/**
	 * Gets the last HD size.
	 * 
	 * @return the last hdSize of Double type.
	 */
	public Double getHdSize() {
		return this.hdSize;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ID: " + getId() + ", Brand: " + getBrand() + ", Model: " + getModel() + 
				", Color: " + getColor() + ", Price: " + getPrice() + ", Warranty: " + 
				getWarranty() + ", RAM Size: " + getRamSize() + ", Processor: " + getProcessor() 
				+ ", Screen Size: " + getScreenSize() + ", HD Size: " + getHdSize();
	}
}

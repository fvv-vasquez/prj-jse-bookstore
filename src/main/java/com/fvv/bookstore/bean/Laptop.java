package com.fvv.bookstore.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Bean class for a Laptop object
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class Laptop extends Hardware implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer ramSize;
	private Double hdSize;
	private String processor;

	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 * 
	 * @param id of the Laptop
	 * @param unitPrice of the Laptop
	 * @param stockQty of the Laptop
	 * @param modificationDate of the Laptop
	 * @param brand of the Laptop
	 * @param warranty of the Laptop
	 * @param ramSize of the Laptop
	 * @param hdSize of the Laptop
	 * @param processor of the Laptop
	 */
	public Laptop(final Long id, final Double unitPrice, final Integer stockQty, final Date 
			modificationDate, final String brand, final Integer warranty, final Integer ramSize, 
			final Double hdSize, final String processor) {
		super(id, unitPrice, stockQty, modificationDate, brand, warranty);
		this.ramSize = ramSize;
		this.hdSize = hdSize;
		this.processor = processor;
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
	public void setRamSize(final Integer ramSize) {
		this.ramSize = ramSize;
	}

	/**
	 * Gets the RAM size in GB.
	 * 
	 * @return the ramSize of Integer type.
	 */
	public Integer getRamSize() {
		return this.ramSize;
	}

	/**
	 * Sets the HD size.
	 * 
	 * @param hdSize of Double type.
	 */
	public void setHdSize(final Double hdSize) {
		this.hdSize = hdSize;
	}

	/**
	 * Gets the HD size.
	 * 
	 * @return the hdSize of Double type.
	 */
	public Double getHdSize() {
		return this.hdSize;
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
	 * Gets the processor.
	 * 
	 * @return the processor of String type.
	 */
	public String getProcessor() {
		return this.processor;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Laptop ID: " + getId() + " - Brand: " + getBrand() + ", Warranty: " + 
				getWarranty() + " months, HD Size: " + getHdSize() + " GB, Unit Price: " +
				getUnitPrice() + ", Stock Quantity: " + getStockQty();
	}
}

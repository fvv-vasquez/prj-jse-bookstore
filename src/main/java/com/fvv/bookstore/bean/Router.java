package com.fvv.bookstore.bean;

/**
 * Bean class for a Router object
 * 
 * Created on 03/20/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public class Router extends Hardware {

	private Integer quantityPort;
	private Integer quantityAntenna;
	private Boolean wireless;
	
	/**
	 * Class constructor specifying the attributes and with super from the Class Hardware
	 */
	public Router(Integer id, String brand, String model, String color, Double price, 
			Integer warranty, Integer quantityPort, Integer quantityAntenna, Boolean wireless) {
		super(id, brand, model, color, price, warranty);
		this.quantityPort = quantityPort;
		this.quantityAntenna = quantityAntenna;
		this.wireless = wireless;
	}

	/**
	 * Class constructor
	 */
	public Router() {
	}

	/**
	 * Sets the quantity of port.
	 * 
	 * @param quantityPort of Integer type.
	 */
	public void setQuantityPort(Integer quantityPort) {
		this.quantityPort = quantityPort;
	}

	/**
	 * Gets the last quantity of port.
	 * 
	 * @return the last quantityPort of Integer type.
	 */
	public Integer getQuantityPort() {
		return this.quantityPort;
	}

	/**
	 * Sets the quantity of antenna.
	 * 
	 * @param quantityAntenna of Integer type.
	 */
	public void setQuantityAntenna(Integer quantityAntenna) {
		this.quantityAntenna = quantityAntenna;
	}

	/**
	 * Gets the last quantity of antenna.
	 * 
	 * @return the last quantityAntenna of Integer type.
	 */
	public Integer getQuantityAntenna() {
		return this.quantityAntenna;
	}

	/**
	 * Sets the wireless.
	 * 
	 * @param wireless of Boolean type.
	 */
	public void setWireless(Boolean wireless) {
		this.wireless = wireless;
	}

	/**
	 * Gets the last information if has wireless.
	 * 
	 * @return the last wireless information of Boolean type.
	 */
	public Boolean hasWireless() {
		return this.wireless;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ID: " + getId() + ", Brand: " + getBrand() + ", Model: " + getModel() + 
				", Color: " + getColor() + ", Price: " + getPrice() + ", Warranty: " + 
				getWarranty() + ", Quantity of Ports: " + getQuantityPort() + 
				", Quantity of Antennas: " + getQuantityAntenna() + ", Wireless: " + hasWireless();
	}	
}

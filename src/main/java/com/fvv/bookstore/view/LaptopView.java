package com.fvv.bookstore.view;

/**
 * LaptopView interface to view the Laptop object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface LaptopView {

	/**
	 * Add a Laptop using Controller.
	 */
	void addLaptop();
	
	/**
	 * Lists all the Laptops using Controller.
	 */
	void listLaptops();

	/**
	 * Update a Laptop already added using Controller.
	 */
	void updateLaptop();
	
	/**
	 * Delete a Laptop using Controller.
	 */
	void removeLaptop();
}

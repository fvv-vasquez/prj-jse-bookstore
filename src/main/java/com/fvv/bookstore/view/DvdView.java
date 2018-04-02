package com.fvv.bookstore.view;

/**
 * DvdView interface to view the Dvd object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface DvdView {
	
	/**
	 * Add a dvd using Controller.
	 */
	void addDvd();
	
	/**
	 * Lists all the dvds using Controller.
	 */
	void listDvds();

	/**
	 * Update a dvd already added using Controller.
	 */
	void updateDvd();
	
	/**
	 * Delete a dvd using Controller.
	 */
	void removeDvd();
}

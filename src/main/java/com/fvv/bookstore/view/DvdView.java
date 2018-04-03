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
	 * Lists all the shows' dvds using Controller.
	 */
	void listDvdsShow();
	
	/**
	 * Lists all the movies' dvds using Controller.
	 */
	void listDvdsMovie();

	/**
	 * Update a dvd already added using Controller.
	 */
	void updateDvd();
	
	/**
	 * Delete a dvd using Controller.
	 */
	void removeDvd();
}

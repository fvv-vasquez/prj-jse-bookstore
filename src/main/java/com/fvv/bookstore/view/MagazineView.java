package com.fvv.bookstore.view;

/**
 * MagazineView interface to view the Magazine object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public interface MagazineView {

	/**
	 * Add a magazine using Controller.
	 */
	void addMagazine();
	
	/**
	 * Lists all magazines using Controller.
	 */
	void listMagazines();

	/**
	 * Update a magazine already added using Controller.
	 */
	void updateMagazine();
	
	/**
	 * Delete a magazine using Controller.
	 */
	void removeMagazine();
}

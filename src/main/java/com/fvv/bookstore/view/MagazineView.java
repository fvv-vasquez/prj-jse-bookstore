package com.fvv.bookstore.view;

/**
 * MagazineView interface to view the Magazine object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public interface MagazineView {

	/**
	 * Add a magazine using Controller.
	 */
	public void addMagazine();
	
	/**
	 * Lists all the magazines using Controller.
	 */
	public void listMagazines();

	/**
	 * Update a magazine already added using Controller.
	 */
	public void updateMagazine();
	
	/**
	 * Delete a magazine using Controller.
	 */
	public void removeMagazine();
}

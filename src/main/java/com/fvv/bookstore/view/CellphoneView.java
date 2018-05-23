package com.fvv.bookstore.view;

/**
 * CellphoneView interface to view the Cellphone object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface CellphoneView {

	/**
	 * Add a Cellphone using Controller.
	 */
	void addCellphone();
	
	/**
	 * Lists all Cellphones using Controller.
	 */
	void listCellphones();

	/**
	 * Update a Cellphone already added using Controller.
	 */
	void updateCellphone();
	
	/**
	 * Delete a Cellphone using Controller.
	 */
	void removeCellphone();
}

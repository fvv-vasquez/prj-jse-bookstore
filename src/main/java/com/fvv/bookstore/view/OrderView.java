package com.fvv.bookstore.view;

/**
 * OrderView interface to view the Order object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface OrderView {

	/**
	 * Add an Order using Controller.
	 */
	void addOrder();
	
	/**
	 * Lists all the order by search month using Controller.
	 */
	void listTotalOrdersMonth();
	
	/**
	 * Lists all the sales per seller using Controller.
	 */
	void listTotalSalesPerSeller();
}

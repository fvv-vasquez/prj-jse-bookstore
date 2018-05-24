package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.exception.ControllerException;

/**
 * Controller interface for Products.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public interface ProductsReportController {

	/**
	 * Lists all products that needs to be replaced in the stock.
	 * 
	 * @return a list of products that needs to be replaced.
	 * @throws ControllerException when a problem in controller happens.
	 */
	List<Product> listStockToReplace() throws ControllerException;
}

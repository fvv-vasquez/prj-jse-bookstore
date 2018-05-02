package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.controller.ProductsReportController;
import com.fvv.bookstore.controller.ProductsReportControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException {
    	
		
		ProductsReportController prReportController = new ProductsReportControllerImpl();
		
		List<Product> products = prReportController.listStockToReplace();
		
		for(Product p : products) {
			System.out.println(p);
		}
    }
}
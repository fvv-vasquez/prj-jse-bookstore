package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.controller.CustomerController;
import com.fvv.bookstore.controller.CustomerControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException {
    	
		CustomerController cuController = new CustomerControllerImpl();
		
		List<Customer> c = cuController.listCustomersByName("o");
		
		for (Customer a : c) {
			System.out.println(a);
		}
    }
}
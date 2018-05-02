package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.controller.OrderController;
import com.fvv.bookstore.controller.OrderControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException {
    	
		OrderController orController = new OrderControllerImpl();
		
		List<Order> orders = orController.listTotalOrdersMonth(4, 2018);
		Integer i = orController.calculateQtyOrdersMonth(orders);
		Double d = orController.calculateTotalOrdersMonth(orders);
		
		System.out.println("Qty: " + i);
		System.out.println("Amount: " + d);
		
		for(Order o : orders) {
			System.out.println(o);
		}
    }
}
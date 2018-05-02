package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.controller.OrderController;
import com.fvv.bookstore.controller.OrderControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		/*OrderController oController = new OrderControllerImpl();
		
		List<Order> orders = oController.listTotalSalesPerSeller(2L);
		
		for(Order o : orders) {
			System.out.println(o);
		}*/
    }
}
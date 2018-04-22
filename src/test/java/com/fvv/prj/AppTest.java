package com.fvv.prj;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.controller.OrderControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException {
    	
		OrderControllerImpl oc = new OrderControllerImpl();
		
		Book book = new Book();
		book.setId(146L);
		
		Order order = new Order();
		order.getOrderItems();
		
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(book);
		orderItem.setQuantity(5);
		
		oc.addOrder(order);
    }
}
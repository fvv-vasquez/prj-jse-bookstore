package com.fvv.prj;

import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.MathUtil;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException {
    	
		/*OrderControllerImpl oc = new OrderControllerImpl();
		
		Book book = new Book();
		book.setId(146L);
		
		Order order = new Order();
		order.getOrderItems();
		
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(book);
		orderItem.setQuantity(5);
		
		oc.addOrder(order);*/
		
		Double value = 23.886724;
		
		System.out.println(value);
		System.out.println(MathUtil.round(value, Constants.PRECISION));
    }
}
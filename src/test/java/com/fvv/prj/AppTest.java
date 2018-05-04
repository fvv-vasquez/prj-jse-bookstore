package com.fvv.prj;

import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.view.OrderView;
import com.fvv.bookstore.view.OrderViewImpl;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		//OrderItemDAO orItemDAO = new OrderItemDAOImpl();
		
		//Order order = new Order();
		//order.setId(104L);
		
		/*OrderDAO orDao = new OrderDAOImpl();
		
		Order o = orDao.listOrderByOrderId(104L);
		System.out.println(o);		
		o.getOrderItems().forEach(System.out::println);*/
		
		OrderView orderView = new OrderViewImpl();
		orderView.listOrderByOrderId();
    }
}
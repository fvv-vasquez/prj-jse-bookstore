package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.dao.OrderDAO;
import com.fvv.bookstore.dao.OrderDAOImpl;
import com.fvv.bookstore.dao.OrderItemDAO;
import com.fvv.bookstore.dao.OrderItemDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		OrderItemDAO orItemDAO = new OrderItemDAOImpl();
		
		Order order = new Order();
		order.setId(96l);
		
		List<OrderItem> orList = orItemDAO.findDvdtemsByOrder(order);
		
		for(OrderItem o : orList ) {
			System.out.println(o);
		}
    }
}
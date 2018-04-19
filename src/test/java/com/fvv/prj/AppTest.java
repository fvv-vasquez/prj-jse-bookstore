package com.fvv.prj;

import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.controller.OrderController;
import com.fvv.bookstore.controller.OrderControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, OrderValidationException, ControllerException {
    	
		Customer ciro = new Customer();
		Employee fatima = new Employee();
		
		ciro.setId(4L);
		fatima.setId(2L);
		
		Product book1 = new Book();
		book1.setId(139L);
		book1.setUnitPrice(30.0);
		
		Product book2 = new Book();
		book2.setId(144L);
		book2.setUnitPrice(30.0);
		
		Product book3 = new Book();
		book3.setId(146L);
		book3.setUnitPrice(30.0);
		
		List<OrderItem> itemsOrder = new ArrayList<>();
		
		Order order = new Order();
		order.setCustomer(ciro);
		order.setEmployee(fatima);
		
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(book1);
		orderItem1.setOrder(order);
		orderItem1.setQuantity(2);
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(book2);
		orderItem2.setOrder(order);
		orderItem2.setQuantity(5);
		
		OrderItem orderItem3 = new OrderItem();
		orderItem3.setProduct(book3);
		orderItem3.setOrder(order);
		orderItem3.setQuantity(2);
		
		itemsOrder.add(orderItem1);
		itemsOrder.add(orderItem2);
		itemsOrder.add(orderItem3);		
		order.setOrderItems(itemsOrder);
		
		/*OrderDAO orderDao = new OrderDAOImpl();
		orderDao.addOrder(order);*/	
		
		OrderController orderController = new OrderControllerImpl();
		orderController.addOrder(order);
		
    }
}
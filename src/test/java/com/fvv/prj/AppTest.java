package com.fvv.prj;

import java.util.ArrayList;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.bean.OrderItem;
import com.fvv.bookstore.bean.Product;
import com.fvv.bookstore.dao.OrderDAO;
import com.fvv.bookstore.dao.OrderDAOImpl;
import com.fvv.bookstore.dao.OrderItemDAO;
import com.fvv.bookstore.dao.OrderItemDAOImpl;
import com.fvv.bookstore.exception.DaoException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException {
    	
		Customer ciro = new Customer();
		Employee fatima = new Employee();
		
		ciro.setId(4L);
		fatima.setId(2L);
		
		Product book1 = new Book();
		book1.setId(139L);
		
		Product book2 = new Book();
		book2.setId(144L);
		
		Product book3 = new Book();
		book3.setId(146L);
		
		List<OrderItem> itemsOrder = new ArrayList<>();
		
		Order order = new Order();
		order.setCustomer(ciro);
		order.setEmployee(fatima);
		order.setOrderAmount(1000.0);
		
		OrderItem orderItem1 = new OrderItem();
		orderItem1.setProduct(book1);
		orderItem1.setOrder(order);
		orderItem1.setQuantity(2);
		orderItem1.setItemAmount(90.0);
		
		OrderItem orderItem2 = new OrderItem();
		orderItem2.setProduct(book2);
		orderItem2.setOrder(order);
		orderItem2.setQuantity(5);
		orderItem2.setItemAmount(250.0);
		
		OrderItem orderItem3 = new OrderItem();
		orderItem3.setProduct(book3);
		orderItem3.setOrder(order);
		orderItem3.setQuantity(2);
		orderItem3.setItemAmount(50.0);
		
		itemsOrder.add(orderItem1);
		itemsOrder.add(orderItem2);
		itemsOrder.add(orderItem3);		
		order.setItemsOrder(itemsOrder);
		
		OrderDAO orderDao = new OrderDAOImpl();
		orderDao.addOrder(order);		
    }
}
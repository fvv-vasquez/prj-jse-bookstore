package com.fvv.prj;

import com.fvv.bookstore.bean.Customer;
import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.dao.OrderDAO;
import com.fvv.bookstore.dao.OrderDAOImpl;
import com.fvv.bookstore.exception.DaoException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException {
    	
		Customer ciro = new Customer();
		Employee fatima = new Employee();
		
		ciro.setId(4L);
		fatima.setId(2L);
		
		Order order = new Order();
		order.setCustomer(ciro);
		order.setEmployee(fatima);
		order.setOrderAmount(1000.0);
		
		OrderDAO orderDao = new OrderDAOImpl();
		
		orderDao.addOrder(order);
    }
}
package com.fvv.prj;

import java.util.Date;

import com.fvv.bookstore.dao.EmployeeDAO;
import com.fvv.bookstore.dao.EmployeeDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.DateUtil;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		
		Date date = new Date();
		
		String inutil = "03/" + "01/" + "2018";
		date = DateUtil.stringToDate(inutil);
		
		Double d = employeeDAO.getTotalSalesByEmployeeAndMonth(2L, date);
		System.out.println(d);
    }
}
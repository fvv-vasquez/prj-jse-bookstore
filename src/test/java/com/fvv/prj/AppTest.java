package com.fvv.prj;

import java.util.Date;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.controller.EmployeeController;
import com.fvv.bookstore.controller.EmployeeControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.DateUtil;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		EmployeeController emController = new EmployeeControllerImpl();
		
		Date date = new Date();
		
		String inutil = "03/" + "01/" + "2018";
		date = DateUtil.stringToDate(inutil);
		
		Employee employee = new Employee();
		employee.setId(2L);
		employee.setSalary(6500.00);
		
		Double d = emController.getSalaryWithCommission(0.15, employee, date);
		System.out.println(d);
    }
}
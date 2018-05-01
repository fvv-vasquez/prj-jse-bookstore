package com.fvv.prj;

import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.controller.EmployeeController;
import com.fvv.bookstore.controller.EmployeeControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException {
    	
		EmployeeController emController = new EmployeeControllerImpl();
		
		List<Employee> employees = emController.listEmployeesByName("R");
		
		for (Employee emp : employees) {
			System.out.println(emp);
		}
    }
}
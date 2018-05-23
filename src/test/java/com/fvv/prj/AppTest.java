package com.fvv.prj;

import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.order.OrderNotFoundException;
import com.fvv.bookstore.exception.order.OrderValidationException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.util.MathUtil;

public class AppTest {
	
	public static void main( String[] args ) throws DaoException, ControllerException, OrderValidationException, PersonNotFoundException, OrderNotFoundException {
    	
		Double value = 36523.78;
		
		System.out.println(MathUtil.formatNumbers(value));
    }
}
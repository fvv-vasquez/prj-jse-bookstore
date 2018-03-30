package com.fvv.bookstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class DateUtil to convert a String into a Date
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public final class DateUtil {

	public static Date stringToDate(final String strDate) {		
		if (strDate != null) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				return format.parse(strDate);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}
		} 
		return null;
	}
}

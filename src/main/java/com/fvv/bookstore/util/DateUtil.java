package com.fvv.bookstore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utility class to handle date operations
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public final class DateUtil {	

	/**
	 * Method to convert a String into a Date
	 * 
	 * @param strDate of String type.
	 * @return a Date.
	 */
	public static Date stringToDate(final String strDate) {		
		if (strDate != null) {
			try {
				SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_MASK);
				return format.parse(strDate);
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}
		} 
		return null;
	}
	
	/**
	 * Method to convert a Date into a String
	 * 
	 * @param date of Date type
	 * @return a String
	 */
	public static String dateToString(final Date date) {	
		if (date != null) {
			return new SimpleDateFormat(Constants.DATE_MASK).format(date);
		} else {
			return null;
		}		
	}
	
	/**
	 * Gets the current date and time in a specific format.
	 * 
	 * @return the formated date.
	 */
	public static String getCurrentDateTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.DATE_TIME_MASK));
	}
}

package com.fvv.bookstore.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility class for Maths.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public final class MathUtil {
	
	/**
	 * To round a double value.
	 * 
	 * @param value of Double type.
	 * @param places of Integer type.
	 * @return a double.
	 */
	public static Double round(final Double value, final Integer places) {
		if(places < 0) throw new IllegalArgumentException();
		
		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * To format a double number.
	 * 
	 * @param value to format.
	 * @return a format number.
	 */
	public static String formatNumbers(final Double value) {
		Locale locale = new Locale("pt", "BR");
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
		return numberFormat.format(value);
	}
}

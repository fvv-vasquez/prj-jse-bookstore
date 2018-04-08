package com.fvv.bookstore.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to convert Strings
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public final class StringUtil {
	
	/**
	 * Convert a List into a String.
	 * 
	 * @param customer of Customer type.
	 * @return a String of preferences products.
	 */
	public static String convertListToString(final List<String> list) {
		String preferences = "";
		for(String pp : list) {
			preferences += pp + "|";
		}
		return preferences.substring(0, preferences.length()-1);
	}

	/**
	 * Convert a String into a List.
	 * 
	 * @param listProducts of String type.
	 * @return a List of preferences products.
	 */
	public static List<String> convertStringToList(final String listProducts, final String token) {
		List<String> preferences = new ArrayList<>();
		String[]products = listProducts.split(token);
		for(String p : products) {
			preferences.add(p);
		}
		return preferences;
	}
}

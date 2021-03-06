package com.fvv.bookstore.util;

import java.util.ArrayList;
import java.util.Arrays;
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
	 * @param listProducts of List type.
	 * @return a String of products' preference 
	 */
	public static String convertListToString(final List<String> listProducts) {
		StringBuilder preferences = new StringBuilder();
		for(String pref : listProducts) {
			preferences.append(pref).append(Constants.PIPE);
		}
		return preferences.substring(0, preferences.length()-1);
	}

	/**
	 * Convert a String into a List.
	 * 
	 * @param listProducts of String type.
	 * @param token of String type
	 * @return a List of products' preference
	 */
	public static List<String> convertStringToList(final String listProducts, final String token) {
		String[]products = listProducts.split(token);
		return new ArrayList<>(Arrays.asList(products));
	}
}

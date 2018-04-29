package com.fvv.bookstore.util;

import java.util.Collection;
import java.util.Map;

/**
 * Utility class to verify collections.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class CollectionsUtil {

	/**
	 * Verify if the List is null or empty.
	 * 
	 * @param collection of Collection type.
	 * @return true if the collection is null or empty, otherwise, false.
	 */
	public static boolean isNullOrEmpty(final Collection<?> collection ) {
	    return collection == null || collection.isEmpty();
	}

	/**
	 * Verify if the Map is null or empty.
	 * 
	 * @param map of Map type.
	 * @return true if the map is null or empty, otherwise, false.
	 */
	public static boolean isNullOrEmpty(final Map<?, ?> map ) {
	    return map == null || map.isEmpty();
	}
}

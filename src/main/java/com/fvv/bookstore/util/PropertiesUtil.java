package com.fvv.bookstore.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Load a properties file.
 * This is an experimental application.
 * Not all messages in the view classes were replaced by properties but that it could've been changed!
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class PropertiesUtil {
	
	private static Properties prop;
	
	static {
		prop = new Properties();
		
		try (InputStream input = new FileInputStream(Constants.CONFIG_PROPERTIES_NAME)) {
			prop.load(input);
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
	}
	
	/**
	 * It reads a property value from a key stored in a file with a key-value format.
	 * 
	 * @param key to insert the constant.
	 * @return a message.
	 */
	public static String get(final String key) {
		return prop.getProperty(key);
	}
}



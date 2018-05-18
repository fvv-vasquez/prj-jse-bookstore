package com.fvv.bookstore.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Load a properties file.
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
		
		try (InputStream input = new FileInputStream("config.properties")) {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * To take a value from a key.
	 * 
	 * @param key to insert the constant.
	 * @return a message.
	 */
	public static String get(final String key) {
		return prop.getProperty(key);
	}
}



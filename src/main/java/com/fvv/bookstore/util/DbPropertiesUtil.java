package com.fvv.bookstore.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Load a DataBase properties file to connection factory.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */

public class DbPropertiesUtil {
	
	private static Properties prop;	
	private static final String DB_DRIVER = "db.mysql.driver";
	private static final String DB_URL = "db.mysql.url";
	private static final String DB_USER = "db.mysql.user";
	private static final String DB_PASS = "db.mysql.pass";
	
	static {
		prop = new Properties();
		
		try (InputStream input = new FileInputStream(Constants.CONFIG_DB_PROPERTIES_NAME)) {
			prop.load(input);
		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
	}
	
	/**
	 * It reads a property value from a key stored in a file with a key-value format.
	 * 
	 * @return a message with the database driver.
	 */
	public static String getDriver() {
		return prop.getProperty(DB_DRIVER);
	}
	
	/**
	 * It reads a property value from a key stored in a file with a key-value format.
	 * 
	 * @return a message with the database url.
	 */
	public static String getUrl() {
		return prop.getProperty(DB_URL);
	}
	
	/**
	 * It reads a property value from a key stored in a file with a key-value format.
	 * 
	 * @return a message with the database user.
	 */
	public static String getUser() {
		return prop.getProperty(DB_USER);
	}
	
	/**
	 * It reads a property value from a key stored in a file with a key-value format.
	 * 
	 * @return a message with the database pass.
	 */
	public static String getPass() {
		return prop.getProperty(DB_PASS);
	}
}

package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class Connection Factory to implement a connection with the database.
 * 
 * @author Fatima Vasquez
 * <p>Created on 21 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class ConnectionFactory {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bookstore_db";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "test1234";

	/**
	 * It opens a connection with the database.
	 * @return a connection object.
	 * @throws SQLException when a problem in database happens.
	 */
    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName(DB_DRIVER);
    		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    	} catch (ClassNotFoundException e) {
    		throw new SQLException(e.getMessage());
    	}
    }
}

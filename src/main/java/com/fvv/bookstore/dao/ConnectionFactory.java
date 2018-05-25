package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fvv.bookstore.util.DbPropertiesUtil;

/**
 * Class Connection Factory to implement a connection with the database.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
 * @version 1.0 	
 *
 */
public class ConnectionFactory {

	/**
	 * It opens a connection with the database.
	 * @return a connection object.
	 * @throws SQLException when a problem in database happens.
	 */
    public static Connection getConnection() throws SQLException {
    	try {
    		Class.forName(DbPropertiesUtil.getDriver());
    		return DriverManager.getConnection(DbPropertiesUtil.getUrl(), DbPropertiesUtil.getUser(), DbPropertiesUtil.getPass());
    	} catch (ClassNotFoundException e) {
    		throw new SQLException(e.getMessage());
    	}
    }
}

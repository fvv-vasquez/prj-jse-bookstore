package com.fvv.bookstore;

import com.fvv.bookstore.menu.Menu;

/**
 * App class to create an application 
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class App {
	
	/**
	 * The main application method responsible to execute it.
	 * 
	 * @param args takes an array of String arguments.
	 */
    public static void main( String[] args ) {
    	new Menu().startApp();
    }
}

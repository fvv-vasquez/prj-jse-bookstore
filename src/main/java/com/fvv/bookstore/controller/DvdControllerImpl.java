/**
 * 
 */
package com.fvv.bookstore.controller;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;

/**
 * 
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
 * @version 1.0 	
 *
 */
public class DvdControllerImpl {
	
	public boolean addDvd(Dvd dvd) {
		
		//supposing this is the dao class
		if (dvd instanceof MovieDvd) {
			System.out.println("insert using movie field");
		} else {
			System.out.println("insert using artista field");
		}
		
		return Boolean.TRUE;
	}

}

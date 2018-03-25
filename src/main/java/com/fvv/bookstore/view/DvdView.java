/**
 * 
 */
package com.fvv.bookstore.view;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Dvd;
import com.fvv.bookstore.bean.MovieDvd;
import com.fvv.bookstore.bean.ShowDvd;
import com.fvv.bookstore.controller.DvdControllerImpl;

/**
 * 
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
 * @version 1.0 	
 *
 */
public class DvdView {
	
	public void addDvd() {
		DvdControllerImpl dvdController = new DvdControllerImpl();
		String input = JOptionPane.showInputDialog("M or S");
		Dvd dvd = null;
		
		if (input.charAt(0) == 'M') {
			MovieDvd dvdMovie = new MovieDvd();
			dvdMovie.setDirector("kid bengala");
			dvd = dvdMovie;
		} else {
			ShowDvd dvdShow = new ShowDvd();
			dvdShow.setArtist("Anitta");
			dvd = dvdShow;
		}
		
		dvd.setGenre("porn");
		dvd.setPrice(10.5);
		dvdController.addDvd(dvd);
	}

}

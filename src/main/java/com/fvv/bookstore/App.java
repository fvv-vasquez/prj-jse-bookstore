package com.fvv.bookstore;

import com.fvv.bookstore.view.BookView;
import com.fvv.bookstore.view.BookViewImpl;

/**
 * Hello world!
 *
 */
public class App {
	
    public static void main( String[] args ) {
    	
    	BookView bookView = new BookViewImpl();
    	
    	bookView.addBook();
    }
}

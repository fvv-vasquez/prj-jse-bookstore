package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.dao.BookDAO;
import com.fvv.bookstore.dao.BookDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;

/**
 * Controller class for a Book object.
 * 
 * @author Fatima Vasquez
 * Created on 24 de mar de 2018	
 * @version 1.0 	
 *
 */
public class BookControllerImpl implements BookController {
	
	private BookDAO bookDao;
	
	/**
	 * Class constructor instantiating a new BookDAOImpl object.
	 */
	public BookControllerImpl() {
		this.bookDao = new BookDAOImpl(); 
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addBook(Book book) throws ControllerException {
		try {
			return this.bookDao.addBook(book);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a book", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Book> listBooks() throws ControllerException {
		List<Book> books;
		try {
			books = this.bookDao.listBooks();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
		return books;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateBook(Book book) throws ControllerException {
		try {
			return this.bookDao.updateBook(book);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a book", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook(Long id) throws ControllerException {
		try {
			this.bookDao.removeBook(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to delete a book", e);
		}
	}
}

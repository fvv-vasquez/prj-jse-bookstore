package com.fvv.bookstore.controller;

import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.dao.BookDAO;
import com.fvv.bookstore.dao.BookDAOImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.book.BookNotFoundException;
import com.fvv.bookstore.exception.book.BookValidationException;
import com.fvv.bookstore.util.Constants;

/**
 * Controller class for a Book object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 24 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class BookControllerImpl implements BookController {
	
	private final BookDAO bookDao;
	
	/**
	 * Class constructor instantiating a new BookDAOImpl object.
	 */
	public BookControllerImpl() {
		this.bookDao = new BookDAOImpl(); 
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean addBook(final Book book) throws BookValidationException, ControllerException {
		try {
			this.validateBook(book);
			return this.bookDao.addBook(book);
		} catch (DaoException e) {
			throw new ControllerException("Error to add a book", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Book> listBooks() throws ControllerException {
		try {
			return this.bookDao.listBooks();
		} catch (DaoException e) {
			throw new ControllerException("Error to load the list", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateBook(final Book book) throws BookValidationException, ControllerException {
		try {
			this.validateBook(book);
			return this.bookDao.updateBook(book);
		} catch (DaoException e) {
			throw new ControllerException("Error to update a book", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook(final Long id) throws ControllerException {
		try {
			this.bookDao.removeBook(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to delete a book", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Book findBook(Long id) throws BookNotFoundException, ControllerException {
		try {
			return this.bookDao.findBook(id);
		} catch (DaoException e) {
			throw new ControllerException("Error to find a book", e);
		}
	}

	/**
	 * Validate if a field is empty.
	 * 
	 * @param book of type Book
	 * @throws BookValidationException if a field is empty.
	 */
	private void validateBook(final Book book) throws BookValidationException {
		StringBuilder sb = new StringBuilder();
		if(book.getAuthor().equals("")) {
			sb.append("Field author cannot be empty.").append(Constants.LINE_SEPARATOR);			
		}
		if(book.getTitle().equals("")) {
			sb.append("Field title cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getGenre().equals("")) {
			sb.append("Field genre cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getPublisher().equals("")) {
			sb.append("Field publisher cannot be empty.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getEditionNumber() <= 0) {
			sb.append("Field edition number cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getIsbn() <= 0) {
			sb.append("Field ISBN cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getPrice() <= 0) {
			sb.append("Field price cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(book.getPublicationYear() <= 0) {
			sb.append("Field publication year cannot be smaller than 0.").append(Constants.LINE_SEPARATOR);
		}
		if(sb.length() > 0) {
			throw new BookValidationException(sb.toString());
		}
	}
}

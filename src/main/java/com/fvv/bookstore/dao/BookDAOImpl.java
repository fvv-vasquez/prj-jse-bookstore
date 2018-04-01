package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fvv.bookstore.bean.Book;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.book.BookNotFoundException;

/**
 * DAO Class of a Book object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 21 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public class BookDAOImpl implements BookDAO {

	/**
	 * {@inheritDoc}
	 */
	public boolean addBook(final Book book) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SqlQueryEnum.BOOK_INSERT.getQuery());
			ps.setString(1, book.getTitle());
			ps.setInt(2, book.getPublicationYear());
			ps.setInt(3, book.getEditionNumber());
			ps.setString(4, book.getAuthor());
			ps.setDouble(5, book.getPrice());
			ps.setInt(6, book.getIsbn());
			ps.setString(7, book.getPublisher());
			ps.setString(8, book.getGenre());
			ps.execute();
			return true;
		} catch(SQLException e) {
			throw new DaoException("Error to add a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to add a book", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Book> listBooks() throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SqlQueryEnum.BOOK_SELECT_ALL.getQuery());
			rs = ps.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("book_id"));
				book.setTitle(rs.getString("book_title"));
				book.setPublicationYear(rs.getInt("book_publication_year"));
				book.setEditionNumber(rs.getInt("book_edition_number"));
				book.setAuthor(rs.getString("book_author"));
				book.setPrice(rs.getDouble("book_price"));
				book.setIsbn(rs.getInt("book_isbn"));
				book.setPublisher(rs.getString("book_publisher"));
				book.setGenre(rs.getString("book_genre"));
				book.setModificationDate(new Date(rs.getTimestamp(
						"book_modification_date").getTime()));
				books.add(book);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to load the list", e);
			}
		}
		return books;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean updateBook(final Book book) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SqlQueryEnum.BOOK_UPDATE.getQuery());
			ps.setString(1, book.getTitle());
			ps.setInt(2, book.getPublicationYear());
			ps.setInt(3, book.getEditionNumber());
			ps.setString(4, book.getAuthor());
			ps.setDouble(5, book.getPrice());
			ps.setInt(6, book.getIsbn());
			ps.setString(7, book.getPublisher());
			ps.setString(8, book.getGenre());
			ps.setLong(9, book.getId());
			ps.execute();
			return true;
		} catch(SQLException e) {
			throw new DaoException("Error to update a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to update a book", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeBook(final Long id) throws DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SqlQueryEnum.BOOK_DELETE.getQuery());
			ps.setLong(1, id);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to delete a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to delete a book", e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Book findBook(Long id) throws BookNotFoundException, DaoException {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs;
		Book book = new Book();
		try {
			conn = ConnectionFactory.getConnection();
			ps = conn.prepareStatement(SqlQueryEnum.BOOK_SELECT_ID.getQuery());
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			if(!rs.next()) {
				throw new BookNotFoundException("Book with ID " + id + " not found");
			} else {
				do {
					book.setId(rs.getLong("book_id"));
					book.setTitle(rs.getString("book_title"));
					book.setPublicationYear(rs.getInt("book_publication_year"));
					book.setEditionNumber(rs.getInt("book_edition_number"));
					book.setAuthor(rs.getString("book_author"));
					book.setPrice(rs.getDouble("book_price"));
					book.setIsbn(rs.getInt("book_isbn"));
					book.setPublisher(rs.getString("book_publisher"));
					book.setGenre(rs.getString("book_genre"));
					book.setModificationDate(new Date(rs.getTimestamp(
							"book_modification_date").getTime()));
				} while (rs.next());
			}			
		} catch(SQLException e) {
			throw new DaoException("Error to find a book", e);
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(SQLException e) {
				throw new DaoException("Error to find a book", e);
			}
		}
		return book;
	}
}

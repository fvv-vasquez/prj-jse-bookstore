package com.fvv.bookstore.enums;

/**
 * Enum for SQL constants.
 * 
 * @author Fatima Vasquez
 * <p>Created on 30 de mar de 2018</p>	
 * @version 1.0 	
 *
 */
public enum SqlQueryEnum {
	
	BOOK_INSERT("INSERT INTO tb_book (book_title, book_publication_year, book_edition_number, "
			+ "book_author, book_price, book_isbn, book_publisher, book_genre, "
			+ "book_modification_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, now())"),
	
	BOOK_SELECT_ALL("SELECT * FROM tb_book"),
	
	BOOK_UPDATE("UPDATE tb_book SET book_title = ?, book_publication_year = ?, "
					+ "book_edition_number = ?, book_author = ?, book_price = ?, book_isbn = ?, "
					+ "book_publisher = ?, book_genre = ?, book_modification_date = now() "
					+ "WHERE book_id = ?"),
	
	BOOK_DELETE("DELETE FROM tb_book WHERE book_id = ?"),
	
	BOOK_SELECT_ID("SELECT * FROM tb_book WHERE book_id = ?"),
	
	MAGAZINE_INSERT("INSERT INTO tb_magazine (mag_name, mag_edition_number, mag_genre, "
					+ "mag_publication_date, mag_publisher, mag_price, mag_modification_date) "
					+ "VALUES (?, ?, ?, ?, ?, ?, now())"),
	
	MAGAZINE_SELECT_ALL("SELECT * FROM tb_magazine"),
	
	MAGAZINE_UPDATE("UPDATE tb_magazine SET mag_name = ?, mag_edition_number = ?, "
					+ "mag_genre = ?, mag_publication_date = ?, mag_publisher = ?, "
					+ "mag_price = ?, mag_modification_date = now() "
					+ "WHERE mag_id = ?"),
	
	MAGAZINE_DELETE("DELETE FROM tb_magazine WHERE mag_id = ?"),
	
	MAGAZINE_SELECT_ID("SELECT * FROM tb_magazine WHERE mag_id = ?");
	
	private String query;
	
	/**
	 * Enum constructor.
	 * 
	 * @param query of String type.
	 */
	private SqlQueryEnum(final String query) {
		this.query = query;
	}

	/**
	 * @return the query.
	 */
	public String getQuery() {
		return query;
	}
	
}

package com.fvv.bookstore.enums;

/**
 * Enum for SQL constants.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>	
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
	
	MAGAZINE_SELECT_ID("SELECT * FROM tb_magazine WHERE mag_id = ?"),
	
	DVD_SHOW_INSERT("INSERT INTO tb_dvd (dvd_title, dvd_total_duration, dvd_price, dvd_genre, "
			+ "dvd_release_year, dvd_code, dvd_show_artist, "
			+ "dvd_modification_date) VALUES(?, ?, ?, ?, ?, ?, ?, now())"),
	
	DVD_MOVIE_INSERT("INSERT INTO tb_dvd (dvd_title, dvd_total_duration, dvd_price, dvd_genre, "
			+ "dvd_release_year, dvd_code, dvd_movie_director, "
			+ "dvd_modification_date) VALUES(?, ?, ?, ?, ?, ?, ?, now())"),
	
	DVD_SELECT_ALL_SHOW("SELECT * FROM tb_dvd WHERE dvd_show_artist IS NOT NULL"),
	
	DVD_SELECT_ALL_MOVIE("SELECT * FROM tb_dvd WHERE dvd_movie_director IS NOT NULL"),
	
	DVD_SHOW_UPDATE("UPDATE tb_dvd SET dvd_title = ?, dvd_total_duration = ?, dvd_price = ?, "
			+ "dvd_genre = ?, dvd_release_year = ?, dvd_code = ?, dvd_show_artist = ?, "
			+ "dvd_modification_date = now() WHERE dvd_id = ?"),
	
	DVD_MOVIE_UPDATE("UPDATE tb_dvd SET dvd_title = ?, dvd_total_duration = ?, dvd_price = ?, "
			+ "dvd_genre = ?, dvd_release_year = ?, dvd_code = ?, dvd_movie_director = ?, "
			+ "dvd_modification_date = now() WHERE dvd_id = ?"),
	
	DVD_DELETE("DELETE FROM tb_dvd WHERE dvd_id = ?"),
	
	DVD_SELECT_ID("SELECT * FROM tb_dvd WHERE dvd_id = ?"),
	
	CELLPHONE_INSERT("INSERT INTO tb_cellphone (cel_brand, cel_price, cel_warranty, "
			+ "cel_storage_memory, cel_camera, cel_modification_date) "
			+ "VALUES (?, ?, ?, ?, ?, now())"),
	
	CELLPHONE_SELECT_ALL("SELECT * FROM tb_cellphone"),
	
	CELLPHONE_UPDATE("UPDATE tb_cellphone SET cel_brand = ?, cel_price = ?, cel_warranty = ?, "
			+ "cel_storage_memory = ?, cel_camera = ?, cel_modification_date = now() "
			+ "WHERE cel_id = ?"),
	
	CELLPHONE_SELECT_ID("SELECT * FROM tb_cellphone WHERE cel_id = ?");
	
	private final String query;
	
	/**
	 * Enum constructor.
	 * 
	 * @param query of String type.
	 */
	SqlQueryEnum(final String query) {
		this.query = query;
	}

	/**
	 * @return the query.
	 */
	public String getQuery() {
		return query;
	}
	
}

package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Router;

/**
 * DAO Interface of a Router object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface RouterDAO {

	/**
	 * Add a router at the bookstore in the database.
	 * 
	 * @param router of Router type.
	 */
	public void addRouter(Router router);

	/**
	 * Lists all the routers in the database.
	 * 
	 * @return a list of routers.
	 */
	public List<Router> listRouters();

	/**
	 * Update a router already add in the database.
	 * 
	 * @param router of Router type.
	 */
	public void updateRouter(Router router);

	/**
	 * Delete a router from the bookstore in the database.
	 * 
	 * @param id of Integer type.
	 */
	public void removeRouter(Integer id);
}

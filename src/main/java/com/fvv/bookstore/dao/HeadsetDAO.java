package com.fvv.bookstore.dao;

import java.util.List;

import com.fvv.bookstore.bean.Headset;

/**
 * DAO Interface of a Headset object, with main database operations from CRUD methods.
 * 
 * Created on 03/21/2018
 * @author Fatima Vasquez
 * @version 1.0
 */
public interface HeadsetDAO {

	/**
	 * Add a headset at the bookstore in the database.
	 * 
	 * @param addHeadset of Headset type.
	 */
	public void addHeadset(Headset headset);

	/**
	 * Lists all the headsets in the database.
	 * 
	 * @return a list of headsets.
	 */
	public List<Headset> listHeadsets();

	/**
	 * Update a headset already add in the database.
	 * 
	 * @param updateHeadset of Headset type.
	 */
	public void updateHeadset(Headset headset);

	/**
	 * Delete a headset from the bookstore in the database.
	 * 
	 * @param removeHeadset of Integer type.
	 */
	public void removeHeadset(Integer id);
}

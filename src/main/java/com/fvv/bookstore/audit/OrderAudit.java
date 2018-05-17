package com.fvv.bookstore.audit;

import com.fvv.bookstore.bean.Order;
import com.fvv.bookstore.util.DateUtil;
import com.fvv.bookstore.util.FileUtil;

/**
 * Class to create an order audit in a file.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class OrderAudit {
	
	/**
	 * Method to add a log message in the file.
	 * 
	 * @param order to abstract the information to put in the message.
	 */
	public void addLogMessage(final Order order) {
		String message = DateUtil.getCurrentDateTime() + " - Order ID: " + order.getId() + " - Employee: " 
		+ order.getEmployee().getName() + " - Total Amount: R$" + order.getOrderAmount(); 
		FileUtil.addAuditMessage(message);
	}
	
	/**
	 * Method to read the file.
	 */
	public void readLogMessage() {
		FileUtil.readOrderLog();
	}
}

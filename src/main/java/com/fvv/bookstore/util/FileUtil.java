package com.fvv.bookstore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Utility class to handle File operations.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class FileUtil {

	/**
	 * Adding an entry to an audit file.
	 * 
	 * @param message to audit entry to save in the file.
	 */
	public static void addAuditMessage(final String message) {
		File file = new File(Constants.AUDIT_FILE_NAME);
		try (
				PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		) {
			pw.println(message);
		} catch (IOException e) {
			System.out.println("Error to save: " + e.getMessage());
		} 
	}

	/**
	 * To read an audit file with order logs.
	 * 
	 * @return the content in the file.
	 */
	public static String readOrderLog() {
		File file = new File(Constants.AUDIT_FILE_NAME);
		BufferedReader br = null;
		StringBuilder log;
		if (file.exists()) {
			String content;
			log = new StringBuilder();
			try {
				br = new BufferedReader(new FileReader(file));
				do {
					content = br.readLine();
					if (content != null) {
						log.append(content).append("\n");
					}
				} while (content != null);
			} catch (IOException e){
				log = new StringBuilder("Error to read the file!");
			} finally {
				try {
					br.close();
				} catch (IOException e){
					log.append("Error to close the file: " + e.getMessage());
				}
			}
		} else {
			log = new StringBuilder("File not found!");
		}
		return log.toString();
	}
}

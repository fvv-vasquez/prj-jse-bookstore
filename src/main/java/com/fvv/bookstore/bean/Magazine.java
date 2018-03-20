package com.fvv.bookstore.bean;

import java.util.Date;

/**
 * 
 * @author Fatima
 *
 */
public class Magazine {
	
	private String name;
	private Integer editionNumber;
	private String genre;
	private Date publicationDate;
	private String publisher;
	private Double price;
	
	public Magazine(String name, Integer editionNumber, String genre, Date publicationDate, 
			String publisher, Double price) {
		this.name = name;
		this.editionNumber = editionNumber;
		this.genre = genre;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.price = price;
	}
	
	public Magazine() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEditionNumber(Integer editionNumber) {
		this.editionNumber = editionNumber;
	}

	public Integer getEditionNumber() {
		return editionNumber;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}
	
	public String toString() {
		return "Magazine Name: " + getName() + ", Edition Number: " + getEditionNumber() + 
				", Genre: " + getGenre() + ", Publication Date: " + getPublicationDate() +
				", Publisher: " + getPublisher() + ", Price: " + getPrice();
	}
}

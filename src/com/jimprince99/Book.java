package com.jimprince99;

public class Book {
	private String book;
	private String author;
	private float price;
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Book(String book, String author, float price) {
		super();
		this.book = book;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [book=" + book + ", author=" + author + ", price=" + price + "]";
	}
	
	

}

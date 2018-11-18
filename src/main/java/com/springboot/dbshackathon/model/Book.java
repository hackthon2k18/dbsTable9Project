package com.springboot.dbshackathon.model;

public class Book {

	private Long bookId;
	private String name;
	private String category;
	private Long price;
	private String author;
	private Long available;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, String name, String category, Long price, String author, Long available) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.category = category;
		this.price = price;
		this.author = author;
		this.available = available;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getAvailable() {
		return available;
	}

	public void setAvailable(Long available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", category=" + category + ", price=" + price + ", author="
				+ author + ", available=" + available + "]";
	}

}

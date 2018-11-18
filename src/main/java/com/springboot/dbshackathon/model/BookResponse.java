package com.springboot.dbshackathon.model;

import java.util.List;

public class BookResponse {

	private List<Book> books;
	private Long count;

	public BookResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookResponse(List<Book> books, Long count) {
		super();
		this.books = books;
		this.count = count;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BookResponse [books=" + books + ", count=" + count + "]";
	}

}

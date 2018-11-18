package com.springboot.dbshackathon.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.model.Book;
import com.springboot.dbshackathon.model.BookResponse;

@Service
public class BooksDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public CommonResponse addBook(Book book) {
		Long bookId = Long
				.valueOf(jdbcTemplate.queryForObject("select nextval('quickstart.sequence_id')", String.class));

		System.out.println("book : " + book);
		CommonResponse response = null;
		try {
			String sql = "INSERT INTO   public.dbs_books(  book_id,  name,  category,  price,  author,  available) VALUES (  ?,  ?,  ?,  ?,  ?,  ?)";
			int rs = jdbcTemplate.update(sql, bookId, book.getName(), book.getCategory(), book.getPrice(),
					book.getAuthor(), book.getAvailable());
			if (rs > 0) {
				response = new CommonResponse();
				response.setId(bookId);
				response.setResponse("Sucessfully added book");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	public BookResponse getbooks(String category) {
		BookResponse response = new BookResponse();
		List<Book> booksList = new ArrayList<Book>();
		Long count = null;
		Book book = null;
		try {
			String sql = "select  book_id as bookId, name, category, price,author,available from public.dbs_books where category = ?";

			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, category);
			count = (long) rows.size();
			for (Map<String, Object> rs : rows) {
				book = new Book();
				book.setBookId((Long) rs.get("bookId"));
				book.setName((String) rs.get("name"));
				book.setCategory((String) rs.get("category"));
				book.setPrice((Long) rs.get("price"));
				book.setAuthor((String) rs.get("author"));
				book.setAvailable((Long) rs.get("available"));
				booksList.add(book);
			}

			response.setBooks(booksList);
			response.setCount(count);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return response;

	}

}

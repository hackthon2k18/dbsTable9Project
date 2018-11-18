package com.springboot.dbshackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dbshackathon.common.CommonResponse;
import com.springboot.dbshackathon.common.UriConstants;
import com.springboot.dbshackathon.dao.BooksDao;
import com.springboot.dbshackathon.model.Book;
import com.springboot.dbshackathon.model.BookResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping(value = "/" + UriConstants.BOOK)
public class BookController {

	@Autowired
	BooksDao booksDao;

	@ApiOperation(value = "Add Book", position = 1)
	@ApiResponse(code = 200, message = "Successfully added Book")
	@RequestMapping(value = UriConstants.INSERT, method = RequestMethod.POST)

	public CommonResponse addBook(@RequestBody Book book) {
		CommonResponse response = null;
		try {
			response = booksDao.addBook(book);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return response;

	}

	@ApiOperation(value = "Get Books", position = 1)
	@ApiResponse(code = 200, message = "Successfully getting Books")
	@RequestMapping(value = UriConstants.FINDALL, method = RequestMethod.POST)

	public BookResponse getAllBooks(@RequestParam String category) {
		BookResponse response = null;
		try {
			response = booksDao.getbooks(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

}

package com.bookshop.service;

import java.util.List;
import java.util.stream.IntStream;

import com.bookshop.model.Book;

public class BookService {
	public List<Book> getAllBook() {
		return IntStream.range(1, 11).mapToObj(value -> new Book(value, "book - " + value, "author - " + value,
				"description - " + value, value * 100, "img - " + value)).toList();
	}
}

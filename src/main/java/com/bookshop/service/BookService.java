package com.bookshop.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.bookshop.config.DbConfig;
import com.bookshop.model.Book;
import com.bookshop.repository.BookRepository;

public class BookService {
	private final BookRepository bookRepository;

	public BookService() {
		bookRepository = new BookRepository();
	}

	public List<Book> getAllBook() {
		return bookRepository.getBooks();
	}

	public Book getBook(int id) {
		return bookRepository.getBook(id);
	}

	public void addOrUpdateBook(Book book) {
		if (book.id() == 0) {
			bookRepository.addBook(book);
		} else {
			bookRepository.updateBook(book);
		}
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteBook(id);
	}
}

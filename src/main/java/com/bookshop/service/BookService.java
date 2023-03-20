package com.bookshop.service;

import java.util.List;

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

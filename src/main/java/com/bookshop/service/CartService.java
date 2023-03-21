package com.bookshop.service;

import java.util.List;

import com.bookshop.model.Book;
import com.bookshop.model.BookUser;
import com.bookshop.repository.CartRepository;

public class CartService {
	private final CartRepository cartRepository;

	public CartService() {
		cartRepository = new CartRepository();
	}

	public void addCart(BookUser bookUser) {
		cartRepository.addCart(bookUser);
	}

	public List<Book> getCart(int userId) {
		return cartRepository.getBookCart(userId);
	}

	public void removeCart(int userId, int bookId) {
		cartRepository.removeBook(userId, bookId);
	}
}

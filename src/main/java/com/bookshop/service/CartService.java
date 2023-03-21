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

	public boolean addCart(BookUser bookUser) {
		boolean isExist = cartRepository.cartExists(bookUser.userId(), bookUser.bookId());

		if (!isExist) {
			cartRepository.addCart(bookUser);
			return true;
		}

		return false;
	}

	public List<Book> getCart(int userId) {
		return cartRepository.getBookCart(userId);
	}

	public void removeCart(int userId, int bookId) {
		cartRepository.removeBook(userId, bookId);
	}
}

package com.bookshop.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.bookshop.model.Book;
import com.bookshop.model.BookUser;
import com.bookshop.repository.CartRepository;
import com.bookshop.repository.OrderRepository;

public class OrderService {
	private final OrderRepository orderRepository;
	private final CartRepository cartRepository;

	public OrderService() {
		orderRepository = new OrderRepository();
		cartRepository = new CartRepository();
	}

	public List<Book> getOrders(int userId) {
		return orderRepository.getOrders(userId);
	}

	public void order(int userId) {
		var books = cartRepository.cartBookUserDetails(userId);
		orderRepository.order(books);
		removeCart(books);
	}

	private void removeCart(List<BookUser> books) {
		CompletableFuture.runAsync(() -> {
			cartRepository.removeBooks(books);
		});
	}

}

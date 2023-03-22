package com.bookshop.utility;

import java.util.List;

import com.bookshop.model.Book;

import jakarta.servlet.http.HttpServletRequest;

public class Helper {
	private Helper() {
	}

	public static String queryStatus(HttpServletRequest request) {
		String queryStatus = "";
		if (request.getParameter("added") != null) {
			queryStatus = "Book added";
		} else if (request.getParameter("updated") != null) {
			queryStatus = "Book updated";
		} else if (request.getParameter("deleted") != null) {
			queryStatus = "Book deleted";
		} else if (request.getParameter("placed") != null) {
			queryStatus = "Order Placed ";
		} else if (request.getParameter("exists") != null) {
			queryStatus = "Cart exists";
		}

		return queryStatus;
	}

	public static String queryStatus(HttpServletRequest request, String suffix) {
		String queryStatus = "";
		if (request.getParameter("added") != null) {
			queryStatus = "Added to " + suffix;
		} else if (request.getParameter("updated") != null) {
			queryStatus = "Updated to " + suffix;
		} else if (request.getParameter("deleted") != null) {
			queryStatus = "Removed from " + suffix;
		} else if (request.getParameter("placed") != null) {
			queryStatus = "Order Placed ";
		} else if (request.getParameter("exists") != null) {
			queryStatus = "Cart exists";
		}

		return queryStatus;
	}

	public static double totalCost(List<Book> books) {
		return books.stream().mapToDouble(book -> book.price()).reduce(0.0, Double::sum);
	}
}

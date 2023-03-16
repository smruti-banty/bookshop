package com.bookshop.controller.bookcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.model.Book;
import com.bookshop.service.BookService;

public class SubmitBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final BookService bookService;

	public SubmitBookController() {
		bookService = new BookService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id").trim());
		String bookName = request.getParameter("bookname").trim();
		String authorName = request.getParameter("authorname").trim();
		double price = Double.parseDouble(request.getParameter("price").trim());
		String imgUrl = request.getParameter("imgurl").trim();
		String description = request.getParameter("description").trim();

		Book book = new Book(id, bookName, authorName, description, price, imgUrl);
		bookService.addOrUpdateBook(book);

		final String QUERY_STRING = id == 0 ? "added" : "updated";
		response.sendRedirect("GetAllBookController?" + QUERY_STRING);
	}

}

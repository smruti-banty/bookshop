package com.bookshop.controller.bookcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.model.Book;
import com.bookshop.service.BookService;

public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService;

	public UpdateBookController() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Book book = bookService.getBook(id);
		request.setAttribute("book", book);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/addbook.jsp");
		requestDispatcher.forward(request, response);
	}
}

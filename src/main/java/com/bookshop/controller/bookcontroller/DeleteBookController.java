package com.bookshop.controller.bookcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.BookService;

public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BookService bookService;

	public DeleteBookController() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bookService.deleteBook(id);
		
		response.sendRedirect("GetAllBookController?deleted");
	}

}

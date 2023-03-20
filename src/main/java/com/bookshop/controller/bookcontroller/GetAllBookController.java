package com.bookshop.controller.bookcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.bookshop.service.BookService;

public class GetAllBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BookService bookService;

	public GetAllBookController() {
		bookService = new BookService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("allbook", bookService.getAllBook());
		request.setAttribute("status", queryStatus(request));
		
		final String PAGE = request.getParameter("page"); 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE + "/index.jsp");
		requestDispatcher.forward(request, response);
	}

	private String queryStatus(HttpServletRequest request) {
		String queryStatus = "";
		if (request.getParameter("Book added") != null) {
			queryStatus = "added";
		} else if (request.getParameter("Book updated") != null) {
			queryStatus = "updated";
		} else if (request.getParameter("Book deleted") != null) {
			queryStatus = "deleted";
		}

		return queryStatus;
	}
}

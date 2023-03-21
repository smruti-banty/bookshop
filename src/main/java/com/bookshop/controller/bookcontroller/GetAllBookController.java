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
		var session = request.getSession(false);
		if (session != null) {
			int role = (int) session.getAttribute("role");

			request.setAttribute("allbook", bookService.getAllBook());
			request.setAttribute("status", queryStatus(request));

			final String PAGE = role == 1 ? "admin" : "user";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE + "/index.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.sendError(404);
		}
	}

	private String queryStatus(HttpServletRequest request) {
		String queryStatus = "";
		if (request.getParameter("added") != null) {
			queryStatus = "Book added";
		} else if (request.getParameter("updated") != null) {
			queryStatus = "Book updated";
		} else if (request.getParameter("deleted") != null) {
			queryStatus = "Book deleted";
		}

		return queryStatus;
	}
}

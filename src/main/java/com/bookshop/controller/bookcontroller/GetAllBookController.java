package com.bookshop.controller.bookcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.IntStream;
import com.bookshop.model.Book;
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

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/index.jsp");
		requestDispatcher.forward(request, response);
	}

	private String queryStatus(HttpServletRequest request) {
		String queryStatus = "";
		if (request.getParameter("added") != null) {
			queryStatus = "added";
		} else if (request.getParameter("updated") != null) {
			queryStatus = "updated";
		} else if (request.getParameter("deleted") != null) {
			queryStatus = "deleted";
		}

		return queryStatus;
	}
}

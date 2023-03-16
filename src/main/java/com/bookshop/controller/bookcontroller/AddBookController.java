package com.bookshop.controller.bookcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.model.Book;


public class AddBookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book(0, "", "", "", 0.0, "");
		request.setAttribute("book", book);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/addbook.jsp");
		requestDispatcher.forward(request, response);
	}

}

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

@WebServlet("/book/allbook")
public class GetAllBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService;
	
	public GetAllBookController() {
		bookService = new BookService();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("allbook", bookService.getAllBook());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/index.jsp");
		requestDispatcher.forward(request, response);
	}


}

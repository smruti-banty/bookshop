package com.bookshop.controller.cartcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.model.BookUser;
import com.bookshop.service.CartService;

/**
 * Servlet implementation class AddCart
 */
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CartService cartService;

	public AddCartController() {
		cartService = new CartService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);

		if (session != null) {
			int userId = (int) session.getAttribute("id");
			int bookId = Integer.parseInt(request.getParameter("bookid"));

			var bookUser = new BookUser(0, userId, bookId);
			boolean addCart = cartService.addCart(bookUser);

			String status = addCart ? "added" : "exists";
			response.sendRedirect("GetAllBookController?" + status);
		} else {
			response.sendError(404);
		}
	}

}

package com.bookshop.controller.cartcontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.CartService;

/**
 * Servlet implementation class RemoveCart
 */
public class RemoveCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CartService cartService;

	public RemoveCartController() {
		cartService = new CartService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);

		if (session != null) {
			int userId = (int) session.getAttribute("id");
			int bookId = Integer.parseInt(request.getParameter("bookid"));

			cartService.removeCart(userId, bookId);
			response.sendRedirect("GetCartController?deleted");
		} else {
			response.sendError(404);
		}
	}

}

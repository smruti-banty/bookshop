package com.bookshop.controller.cartcontroller;

import static com.bookshop.utility.Helper.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.CartService;

/**
 * Servlet implementation class GetCart
 */
public class GetCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_PAGE = "user";
	private final CartService cartService;

	public GetCartController() {
		cartService = new CartService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);

		if (session != null) {
			int userId = (int) session.getAttribute("id");
			var books = cartService.getCart(userId);
			
			request.setAttribute("allbook", books);
			request.setAttribute("status", queryStatus(request, "cart"));
			request.setAttribute("totalcost", totalCost(books));
			
			var requestDispatcher = request.getRequestDispatcher(USER_PAGE + "/cart.jsp");
			requestDispatcher.forward(request, response);

		} else {
			response.sendError(404);
		}
	}
	
}

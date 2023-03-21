package com.bookshop.controller.ordercontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.OrderService;

/**
 * Servlet implementation class AddOrder
 */
public class AddOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final OrderService orderService;

	public AddOrderController() {
		orderService = new OrderService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);

		if (session != null) {
			int userId = (int) session.getAttribute("id");
			orderService.order(userId);
			
			response.sendRedirect("GetOrderController?placed");
			
		} else {
			response.sendError(404);
		}
	}
}

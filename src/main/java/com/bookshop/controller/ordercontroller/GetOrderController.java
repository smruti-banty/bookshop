package com.bookshop.controller.ordercontroller;

import static com.bookshop.utility.Helper.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.OrderService;

/**
 * Servlet implementation class GetOrder
 */
public class GetOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER_PAGE = "user";
	private final OrderService orderService;

	public GetOrderController() {
		orderService = new OrderService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var session = request.getSession(false);

		if (session != null) {
			int userId = (int) session.getAttribute("id");
			var books = orderService.getOrders(userId);

			request.setAttribute("allbook", books);
			request.setAttribute("totalcost", totalCost(books));
			
			var requestDispatcher = request.getRequestDispatcher(USER_PAGE + "/order.jsp");
			requestDispatcher.forward(request, response);
			
		} else {
			response.sendError(404);
		}
	}

}

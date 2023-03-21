package com.bookshop.controller.usercontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.UserService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userService;
	private final String loginSignupPage = "/loginsignup";

	public LoginController() {
		userService = new UserService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		var user = userService.login(email, password);

		if (user.userId() == -1) {
			request.setAttribute("status", "Invalid user");
			var requestDispatcher = request.getRequestDispatcher(loginSignupPage + "/login.jsp");
			requestDispatcher.forward(request, response);
		} else {
			var session = request.getSession(true);
			session.setAttribute("id", user.userId());
			session.setAttribute("role", user.role());

			response.sendRedirect("GetAllBookController");
		}
	}

}

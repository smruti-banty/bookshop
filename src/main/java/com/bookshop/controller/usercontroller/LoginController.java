package com.bookshop.controller.usercontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.service.LoginSignupService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginSignupService loginSignupService;
	private final String loginSignupPage = "/loginsignup";

	public LoginController() {
		loginSignupService = new LoginSignupService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		var user = loginSignupService.login(email, password);

		if (user.userid() == -1) {
			request.setAttribute("status", "Invalid user");
			var requestDispatcher = request.getRequestDispatcher(loginSignupPage + "/login.jsp");
			requestDispatcher.forward(request, response);
		} else {
			var session = request.getSession(true);
			session.setAttribute("id", user.userid());

			if (user.role() == 1) {
				response.sendRedirect("GetAllBookController?page=admin");
			} else {
				response.sendRedirect("GetAllBookController?page=user");
			}
		}
	}

}

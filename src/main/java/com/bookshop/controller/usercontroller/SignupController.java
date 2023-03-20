package com.bookshop.controller.usercontroller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bookshop.model.User;
import com.bookshop.service.LoginSignupService;

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final LoginSignupService loginSignupService;   
    private final String loginSignupPage = "/loginsignup";
    
    public SignupController() {
        loginSignupService = new LoginSignupService();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String number = request.getParameter("mobilenumber");
		String address = request.getParameter("address");
		
		User user = new User(0, name, email, password, number, address, 0);
		boolean register = loginSignupService.register(user);
		
		if(!register) {
			request.setAttribute("status", "Email Already exist");
			var requestDispatcher = request.getRequestDispatcher( loginSignupPage + "/signup.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("status", "Account created");
			var requestDispatcher = request.getRequestDispatcher( loginSignupPage + "/login.jsp");
			requestDispatcher.forward(request, response);	
		}
	}

}

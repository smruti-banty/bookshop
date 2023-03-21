<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
final String PATH = request.getContextPath();
final String COMMON_JSP_PATH = "/commonfile";
final String COMMON_CSS_PATH = PATH + COMMON_JSP_PATH + "/css";
final String COMMON_JS_PATH = PATH + COMMON_JSP_PATH + "/js";
final String LOGIN_SIGNUP_PATH = PATH + "/loginsignup";
%>
<%
pageContext.include(COMMON_JSP_PATH + "/basichtml.jsp");
%>
<link rel="stylesheet" href="<%=COMMON_CSS_PATH%>/formstyling.css">
<script type="text/javascript" src="<%=COMMON_JS_PATH%>/script.js" defer></script>
</head>
<body>
	<%
	pageContext.include(COMMON_JSP_PATH + "/popup.jsp");
	%>
	<div class="container-center">
		<div class="form-container">
			<h2>Sign up</h2>
			<form method="post" action="<%= PATH %>/SignupController">
				<div class="form-group">
					<label>Email</label> <input type="text" name="email"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Password</label> <input type="password" name="password"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Name</label> <input type="text" name="name"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Mobile Number</label> <input type="text" name="mobilenumber"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Address</label>
					<textarea rows="4" class="form-control" name="address" required></textarea>
				</div>

				<div class="button-group">
					<input type="submit">
				</div>
			</form>
			<div class="form-links">
				<a href="<%=LOGIN_SIGNUP_PATH%>/login.jsp">Existing user ?</a>
			</div>
		</div>

	</div>
</body>
</html>
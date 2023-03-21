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
<script>
window.history.forward(1)
</script>
</head>
<body>
	<%
	pageContext.include(COMMON_JSP_PATH + "/popup.jsp");
	%>
	<div class="container-center">
		<div class="form-container">
			<h2>Login</h2>
			<form method="post" action="<%= PATH %>/LoginController">
				<div class="form-group">
					<label>Enter Email</label> <input type="text" name="email"
						class="form-control" required>
				</div>

				<div class="form-group">
					<label>Enter Password</label> <input type="password"
						name="password" class="form-control" required>
				</div>


				<div class="button-group">
					<input type="submit">
				</div>
			</form>
			<div class="form-links">
				<a href="<%=LOGIN_SIGNUP_PATH%>/signup.jsp">New user ?</a>
			</div>
		</div>

	</div>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.bookshop.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!@SuppressWarnings("unchecked")%>

<%
final String PATH = request.getContextPath();
final String USER_PATH = PATH + "/user";
final String USER_CSS_PATH = USER_PATH + "/css";
final String COMMON_JSP_PATH = "/commonfile";
final String COMMON_CSS_PATH = PATH + COMMON_JSP_PATH + "/css";
final String COMMON_JS_PATH = PATH + COMMON_JSP_PATH + "/js";

List<Book> books = (List<Book>) request.getAttribute("allbook");
String status = (String) request.getAttribute("status");
%>
<%
pageContext.include(COMMON_JSP_PATH + "/basichtml.jsp");
%>
<link rel="stylesheet" href="<%=USER_CSS_PATH%>/index.css">
<link rel="stylesheet" href="<%=COMMON_CSS_PATH%>/logout.css">
<script type="text/javascript" src="<%=COMMON_JS_PATH%>/script.js" defer></script>
</head>
<body>
	<header>
		<h2>Book shop</h2>
	</header>

	<%
	pageContext.include(COMMON_JSP_PATH + "/popup.jsp");
	%>

	<main>
		<section class="image-section"></section>
		<section class="book-section">
			<div class="card-container">
				<%
				for (Book book : books) {
				%>
				<div class="card">
					<div class="card-header">
						<h2><%=book.name()%></h2>
						<img src="<%=book.imgUrl()%>" alt="img">
					</div>
					<div class="card-body">
						<b><%=book.author()%></b>
						<p><%=book.descrption()%></p>
					</div>
					<div class="card-footer">
						<p>
							&#8377;
							<%=book.price()%></p>
							<div>
							<a href="#">Add to cart</a>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</section>
	</main>

	<!-- Logout -->

	<%
	pageContext.include(COMMON_JSP_PATH + "/logout.html");
	%>

</body>
</html>
<%@page import="com.bookshop.model.Book"%>
<%@page import="java.util.List"%>
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
double totalCost = (double) request.getAttribute("totalcost");
%>
<%
pageContext.include(COMMON_JSP_PATH + "/basichtml.jsp");
%>
<link rel="stylesheet" href="<%=USER_CSS_PATH%>/index.css">
<link rel="stylesheet" href="<%=COMMON_CSS_PATH%>/logout.css">
<script type="text/javascript" src="<%=COMMON_JS_PATH%>/script.js" defer></script>
</head>
<body>
	<%
	pageContext.include(COMMON_JSP_PATH + "/popup.jsp");
	%>
	<header>
		<h2>Book shop</h2>
	</header>
	<nav>
		<a href="<%=PATH%>/GetAllBookController">Home</a> <a
			href="<%=PATH%>/GetCartController">Cart</a> <a
			href="<%=PATH%>/GetOrderController" class="link-active">Order</a>
	</nav>
	<main>
		<section class="image-section"></section>
		<section class="book-section">
			<div class="container">
				<%
				for (Book book : books) {
				%>
				<div class="card">
					<div class="card-left">
						<div class="img-box">
							<img src="<%=book.imgUrl()%>" alt="img">
						</div>
					</div>
					<div class="card-right">
						<div class="card-head">
							<div class="details">
								<h1><%=book.name()%></h1>
								<p><%=book.author()%></p>
							</div>
							<div class="description">
								<p><%=book.descrption()%></p>
							</div>
						</div>
						<div class="card-footer">
							<div class="price">
								<h3>
									&#8377;
									<%=book.price()%></h3>
							</div>
							<p class="button">Delivered</p>
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
<%@page import="java.util.List"%>
<%@page import="com.bookshop.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Shop</title>
<link rel="stylesheet" href="/bookshop/admin/css/index.css">
<link style="st" href="">
</head>
<body>
	<header>
		<h2>Admin Page</h2>
	</header>

	<section class="book-section">

		<div class="container">
			<%
			List<Book> list = (List<Book>) request.getAttribute("allbook");
			for (Book book : list) {
			%>
			<div class="card">
				<div class="card-header">
					<img src="<%=book.imgUrl()%>" alt="book">
				</div>
				<div class="card-body">
					<h2><%=book.name()%></h2>
					<p><%=book.descrption()%></p>
				</div>

				<div class="card-footer">
					<p>
						<%=book.price()%></p>
					<button type="button">Add to Cart</button>
				</div>

			</div>
			<%
			}
			%>

		</div>
	</section>
</body>
</html>
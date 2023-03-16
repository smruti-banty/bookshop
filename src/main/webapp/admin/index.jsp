<%@page import="java.util.List"%>
<%@page import="com.bookshop.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!@SuppressWarnings("unchecked")%>

<%
final String PATH = request.getContextPath();
final String ADMIN_PATH = PATH + "/admin";
final String ADMIN_CSS_PATH = ADMIN_PATH + "/css";
final String ADMIN_JS_PATH = ADMIN_PATH + "/js";

List<Book> books = (List<Book>) request.getAttribute("allbook");
String status = (String) request.getAttribute("status");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Shop</title>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2232/2232688.png">
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/index.css">
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/indexreponsive.css">
<script type="text/javascript" src="<%=ADMIN_JS_PATH%>/script.js" defer></script>
</head>
<body>
	<header>
		<h2>Admin Page</h2>
	</header>

	<div class='side-pop <%=status.isEmpty() ? "d-none" : ""%>'>
		<p>
			Book
			<%=status%></p>
	</div>

	<section class="book-section">
		<a href="<%=PATH + "/AddBookController"%>" class="button">Add Book</a>
		<div class="container">
			<table>
			<caption>BOOK LISTS</caption>
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Author</th>
						<th scope="col">Image</th>
						<th scope="col">Price</th>
						<th scope="col">Description</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Book book : books) {
					%>
					<tr>
						<td><%=book.name()%></td>
						<td><%=book.author()%></td>
						<td><img src="<%=book.imgUrl()%>" alt="book" loading="lazy"></td>
						<td>&#8377; <%=book.price()%></td>
						<td title="<%=book.descrption()%>"><p class="description"><%=book.descrption()%></p></td>
						<td><a
							href="<%=PATH%>/UpdateBookController?id=<%=book.id()%>">Update</a>
							<a href="<%=PATH%>/DeleteBookController?id=<%=book.id()%>">Delete</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</section>
</body>
</html>
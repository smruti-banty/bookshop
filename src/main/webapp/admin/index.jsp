<%@page import="java.util.List"%>
<%@page import="com.bookshop.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
final String PATH = request.getContextPath();
final String ADMIN_PATH = PATH + "/admin";
final String ADMIN_CSS_PATH = ADMIN_PATH + "/css";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Book Shop</title>
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/index.css">
</head>
<body>

	<%
	List<Book> books = (List<Book>) request.getAttribute("allbook");
	String status = (String) request.getAttribute("status");
	%>

	<header>
		<h2>Admin Page</h2>
	</header>

	<!-- Status Add or Update -->
	<%
	if (!status.isEmpty()) {
	%>
	<div class="side-pop">
		<p>
			Book
			<%=status%></p>
	</div>
	<%
	}
	%>

	<section class="book-section">
		<a href="<%=PATH + "/AddBookController"%>" class="button">Add Book</a>
		<div class="container">
			<table>
				<thead>
					<tr>
						<th>Action</th>
						<th>Name</th>
						<th>Author</th>
						<th>Price</th>
						<th>Image</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Book book : books) {
					%>
					<tr>
						<td><a
							href="<%=PATH%>/UpdateBookController?id=<%=book.id()%>">Update</a>
							<a href="<%=PATH%>/DeleteBookController?id=<%=book.id()%>">Delete</a></td>
						<td><%=book.name()%></td>
						<td><%=book.author()%></td>
						<td><%=book.price()%></td>
						<td><img src="<%=book.imgUrl()%>" alt="book"></td>
						<td><%=book.descrption()%></td>
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
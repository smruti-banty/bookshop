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
<title>Book Shop</title>
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/addbook.css">
</head>
<body>
	<%
	Book book = (Book) request.getAttribute("book");
	%>
	<header>
		<h2>Admin Page</h2>
	</header>

	<section class="book-section">
		<div class="link">
			<a href='<%=PATH + "/GetAllBookController"%>'>Back to home</a>
		</div>

		<div class="container">
			<div class="form-container">
				<h2>Add Book</h2>
				<form method="post" action="<%=PATH%>/SubmitController">
					<div class="form-group">
						<label>Book Name</label> <input type="text" name="bookname"
							class="form-control" value="<%=book.name()%>">
					</div>

					<div class="form-group">
						<label>Author Name</label> <input type="text" name="authorname"
							class="form-control" value="<%=book.author()%>">
					</div>

					<div class="form-group">
						<label>Book Price</label> <input type="text" name="price"
							class="form-control" value="<%=book.price()%>">
					</div>

					<div class="form-group">
						<label>Book URL</label> <input type="text" name="imgurl"
							class="form-control" value="<%=book.imgUrl()%>">
					</div>

					<div class="form-group">
						<label>Description</label>
						<textarea rows="4" name="description" class="form-control"><%=book.descrption()%>
						</textarea>
					</div>

					<input type="hidden" name="id" value="<%=book.id()%>">

					<div class="button-group">
						<input type="submit">
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
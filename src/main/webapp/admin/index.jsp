<%@page import="java.util.List"%>
<%@page import="com.bookshop.model.Book"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%!@SuppressWarnings("unchecked")%>

<%
final String PATH = request.getContextPath();
final String ADMIN_PATH = PATH + "/admin";
final String ADMIN_CSS_PATH = ADMIN_PATH + "/css";
final String COMMON_JSP_PATH = "/commonfile";
final String COMMON_CSS_PATH = PATH + COMMON_JSP_PATH + "/css";
final String COMMON_JS_PATH = PATH + COMMON_JSP_PATH + "/js";

List<Book> books = (List<Book>) request.getAttribute("allbook");
String status = (String) request.getAttribute("status");
%>
<%
pageContext.include(COMMON_JSP_PATH + "/basichtml.jsp");
%>
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/index.css">
<link rel="stylesheet" href="<%=ADMIN_CSS_PATH%>/indexreponsive.css">
<link rel="stylesheet" href="<%=COMMON_CSS_PATH%>/logout.css">
<script type="text/javascript" src="<%=COMMON_JS_PATH%>/script.js" defer></script>
</head>
<body>
	<header>
		<h2>Admin Page</h2>
	</header>

	<%
	pageContext.include(COMMON_JSP_PATH + "/popup.jsp");
	%>

	<section class="book-section">
		<a href="<%=PATH + "/AddBookController"%>" class="button">Add Book</a>
		<div class="container">
			<table>
				<caption>BOOK LISTS</caption>
				<thead>
					<tr>
						<th scope="col">Image</th>
						<th scope="col">Name</th>
						<th scope="col">Author</th>
						<th scope="col">Price</th>
						<th scope="col">Description</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (books.size() == 0) {
					%>
					<tr>
						<td colspan="6">No Book Found</td>
					</tr>
					<%
					}
					%>

					<%
					for (Book book : books) {
					%>
					<tr>
						<td><img src="<%=book.imgUrl()%>" alt="book"></td>
						<td><%=book.name()%></td>
						<td><%=book.author()%></td>
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

	<!-- Logout -->

	<%
	pageContext.include(COMMON_JSP_PATH + "/logout.html");
	%>

</body>
</html>
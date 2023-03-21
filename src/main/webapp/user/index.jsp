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
			<div class="container">
				<%
				for (Book book : books) {
				%>
				<div class="card">
            <div class="card-left">
                <div class="img-box">
                    <img src="https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/51K24abqIvL.jpg"
                        alt="img">
                </div>
            </div>
            <div class="card-right">
                <div class="card-head">
                    <div class="details">
                        <h1>Core Java</h1>
                        <p>Rashmi Kant Das</p>
                    </div>
                    <div class="description">
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Facere incidunt non doloribus
                            doloremque dolorem. Quaerat porro obcaecati distinctio modi doloribus, deleniti, atque,
                            animi
                            vero nam veniam sunt laboriosam fugiat necessitatibus?
                        </p>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="price">
                        <h3>&#8377; 1200.98</h3>
                    </div>
                    <button class="button">Add Cart</button>
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
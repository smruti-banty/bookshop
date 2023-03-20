<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String status = (String) request.getAttribute("status");
%>

<div class='side-pop <%= status == null ? "d-none" : status.isEmpty() ? "d-none" : ""%>'>
	<p><%=status%></p>
</div>
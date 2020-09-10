<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Expires", "0");

	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
%>
<form action="index.jsp">
    <input type="submit" value="Home">
</form>
<form action="index.jsp">
    <input type="submit" value="Logout">
</form>
	Archive Thread
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
		</tr>
			<c:forEach items="${archiveContactList}" var="archiveContactList">
				<tr>
					<td>${archiveContactList.name}</td>
					<td>${archiveContactList.email}</td>
					<td>${archiveContactList.message}</td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<br>
	Active Thread
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
		</tr>
			<c:forEach items="${activeContactList}" var="activeContactList">
				<tr>
					<td>${activeContactList.name}</td>
					<td>${activeContactList.email}</td>
					<td>${activeContactList.message}</td>
					<td>
						<form action="movetoarchive" method="post">
							<button type="submit" name="moveToActive" value="${activeContactList.email}">Move to Archive</button>
						</form>
					</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>
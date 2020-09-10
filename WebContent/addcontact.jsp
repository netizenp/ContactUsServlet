<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addcontact" method="post">
		Name: <input type="text" name="name" required><br>
		Email: <input type="email" name="email" required><br>
		Message: <textarea rows="" cols="" name="message" required></textarea><br>
		<input type="submit">
	</form>
</body>
</html>
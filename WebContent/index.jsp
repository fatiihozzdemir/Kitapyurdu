<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>

	
	<form action="register.html" style="border: 1px solid #ccc"
		method="post">
		<input type="submit"  name="SignUp" value="Sign Up">
	</form>

	
	<form action="login.html" style="border: 1px solid #ccc" method="post">
		<input type="submit" name="LogIn" value="Log In">
	</form>

	<form action="bookController" style="border: 1px solid #ccc"
		method="get">
		<input type="submit" value="Show BookList">
	</form>

</body>
</html>
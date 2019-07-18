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
<h1>Dashboard</h1>

	

	
	<form action="AdminDashBoardAddBook" style="border: 1px solid #ccc"
		method="post">
		<input type="submit" name="BookRegister" value="AddBook">
	</form>

	<form action="AdminDashBoardAddBook" style="border: 1px solid #ccc"
		method="get">
		<input type="submit" value="Show BookList">
	</form>
	<form action="AdminDashBoardAddCategory" style="border: 1px solid #ccc"
		method="get">
		<input type="submit" value="Add Writer and Category">
	</form>	
</body>
</html>
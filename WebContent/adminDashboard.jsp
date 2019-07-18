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
	
	<form action="AdminDashBoardAddBook"  
		method="GET">
		<input type="submit" name="BookRegister" value="AddBook">
	</form>

	<form action="AdminDashBoardShowBookList"  
		method="GET">
		<input type="submit" value="Show BookList">
	</form>
	<form action="AdminDashBoardAddCategory" 
		method="GET">
		<input type="submit" value="Add Writer and Category">
	</form>	
</body>
</html>
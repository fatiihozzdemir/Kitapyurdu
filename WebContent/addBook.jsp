<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<a href="adminDashboard.jsp">Go Back Home Page</a>
	<h1>Book Register Form</h1>
	<form action="AdminDashBoardAddBook" method="post">
		<table style="with: 50%">

			<tr>
				<td>Book Name</td>
				<td><input type="text" name="bookName" required/></td>
			</tr>
			<tr>
				<td>Writer Name</td>
				<td><select  name="bWriter" required>
						<c:forEach items="${writerList}" var="writer">
							<option value="${writer.writerId}">${writer.writerName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Publisher Name</td>
				<td><input type="text" name="publisherName" required/></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="price" required></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><select  name="bCategory" required>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryId}">${category.categoryName}</option>
						</c:forEach>
				</select></td>
			</tr>

		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
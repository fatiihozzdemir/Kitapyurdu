<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Others</title>
</head>
<body>
	<a href="adminDashboard.jsp">Go Back Home Page</a>
	
		<table border="1" cellpadding="5">
			<caption>Categories</caption>
			<tr>
				<th>Category Name</th>
				<th colspan="2"> Update</th>
			</tr>
				<c:forEach items="${categoryList}" var="category">
			<tr>
					<td>${category.categoryName}</td>
				<form action=AdminDashBoardAddCategory>
					<td><button type="submit" name="editCategory" value=${category.categoryId} formmethod="post">Edit</button></td>
					<td><button type="submit" name="deleteCategory" value=${category.categoryId} formmethod="post">Delete!</button></td>
				</form>
			</tr>
				</c:forEach>
			<tr>
				<form action = others>
					<td><input type="text" name="categoryName" required/></td>
					<td colspan="2"><button type="submit" name="addCategory" value="addCategory" formmethod="post">Add Category</button></td>
				</form>
			</tr>
		</table>
	</div>
	
	
	
		<table border="1" cellpadding="5">
			<caption>Writers</caption>
			<tr>
				<th>Writer Name</th>
				<th>Gender</th>
				<th>Writer Birthday</th>
				<th colspan="2"> Update</th>
			</tr>
				<c:forEach items="${writerList}" var="writer">
			<tr>
					<td>${writer.writerName}</td>
					<td>${writer.gender}</td>
					<td>${writer.birthDate}</td>
				<form action=AdminDashBoardAddCategory>
					<td><button type="submit" name="editWriter" value=${writer.writerId} formmethod="post">Edit</button></td>
					<td><button type="submit" name="deleteWriter" value=${writer.writerId} formmethod="post">Delete!</button></td>
				</form>
			</tr>
				</c:forEach>
			<tr>
				<form action = AdminDashBoardAddCategory>
					<td><input type="text" name="writerName" required/></td>
					<td>
						<input type="radio" name="gender" value="MALE" checked> Male
  						<input type="radio" name="gender" value="FEMALE"> Female
					</td>
					<td><input type="date" name="birthDate" required></td>
					<td colspan="2"><button type="submit" name="addWriter" value="addWriter" formmethod="post" >Add Writer</button></td>
				</form>
			</tr>
		</table>
	
	
</body>
</html>
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
	<a href="/Kitapkurdu">Go Back Home Page</a>
	<h1>Edit Category</h1>
	<form action="AdminDashBoardAddCategory" method="post">
		<table style="with: 50%">
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>Category Name</td>
					<td><input type="text" value=${category.categoryName} name="categoryName" required/></td>
				</tr>
				<tr>
					<td><input type="hidden" value=${category.categoryId} name="categoryId" required/></td>
				</tr>
					<td><input type="submit" name="editCategoryPage" value="Edit Category"></td>
				</tr>
			</c:forEach>
		</table>
		
	</form>
</body>
</html>




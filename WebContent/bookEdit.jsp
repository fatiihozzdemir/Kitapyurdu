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
	<a href="adminDashboard.jsp">Go Back Home Page</a>

	<h1>Edit Book</h1>
	<form action="AdminDashBoardAddBook" method="post">
		<table style="with: 50%">
			<c:forEach items="${bookList}" var="bookList">

				<tr>
					<td>Book Name</td>
					<td><input type="text" value=${bookList.bookName} name="bookName" required/></td>
				</tr>
				<tr>
					<td>Writer Name</td>
					<td><select input type="text" name="bookWriter" required>
							<c:forEach items="${writerList}" var="writer">
								<option value=${writer.writerId}>${writer.writerName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Publisher Name</td>
					<td><input type="text" value=${bookList.bookPublisher} name="publisherName" required/></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" step="0.01" min="0.01" max="999.99" value=${bookList.bookPrice} name="bookPrice" required></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><select input type="text" name="bCategory" required>
						<c:forEach items="${categoryList}" var="category">
							<option value=${category.categoryId}>${category.categoryName}</option>
						</c:forEach>
				</select></td>
				</tr>
				<tr>
					<td><input type="hidden" value=${bookList.bookId} name="bookId" required/></td>
				</tr>
				<tr>
					<td><input type=hidden value=${bookList.insertDate} name="insertDate" required/></td>
				</tr>
				<tr>
					<td><input type="submit" name="editPage" value="Edit book"></td>
				</tr>
			</c:forEach>
		</table>
		
	</form>
</body>
</html>




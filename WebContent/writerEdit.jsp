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
	<a href="adminDashboard.jsp">Return to Index</a>
	<h1>Edit Writer</h1>
	<form action="registerController" method="post">
		<table style="with: 50%">
			<c:forEach items="${writerList}" var="writer">
				<tr>
					<td>Writer Name</td>
					<td><input type="text" value=${writer.writerName} name="writerName" required/></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td>	<input type="radio" name="gender" value="Male" checked> Male
  							<input type="radio" name="gender" value="Female"> Female
  					</td>
  				</tr>
  				<tr>
  					<td>Birth Date</td>
  					<td><input type="date" value=${writer.birthDate} name="birthDate" required></td>
  				</tr>
  				<tr>
					<td><input type="hidden" value=${writer.writerId} name="writerId" required/></td>
				</tr>
  				<tr>		
  					<td><input type="submit" name="editWriterPage" value="Edit Writer"></td>
  				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
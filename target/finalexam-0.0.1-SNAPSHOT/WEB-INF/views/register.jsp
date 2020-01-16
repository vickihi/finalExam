<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a user</title>
</head>
<body>
	<div align="center">
		<form:form action="saveuser" method="post" modelAttribute="user">
			<table>
				<form:hidden path="id" />

				<tr>
					<td>Username</td>
					<td><form:input path="username" /></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><form:input path="password" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div>
		<c:forEach var="user" items="${userList}">
			<c:out value="${user.name}"></c:out>
			<c:out value="${user.password}"></c:out>
		</c:forEach>
	</div>
</body>
</html>
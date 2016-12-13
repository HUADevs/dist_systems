<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">

		<h2>Users</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Username</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.Userid}</td>
						<td><a
							href="<spring:url 
							value="/user/${user.UserName}"/>">${user.FirstName}${user.LastName}</a></td>
						<td>${user.UserName}</td>
						<td>${user.AssignedRole}</td>
						<td><a
							href="<spring:url 
							value="/user/${user.UserName}/edit"/>">editIcon</a></td>
						<td>${user.UserName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
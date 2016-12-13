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
	<jsp:include page="../views/fragments/admin-header.jsp"></jsp:include>

	<div class="container">

		<h2>Users</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Username</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>${user.Userid}</td>
						<td>${user.FirstName}</td>
						<td>${user.LastName}</td>
						<td>${user.UserName}</td>
						<td>${user.AssignedRole.RoleName}</td>
						<td>editIcon</td>
						<td>${user.UserName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
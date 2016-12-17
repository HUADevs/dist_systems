<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../views/fragments/admin-header.jsp"></jsp:include>

	<div class="container">

		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Users</span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Username</th>
						<th>Role</th>
						<th>Department</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.userId}</td>
							<td>${user.firstName}${user.lastName }</td>
							<td>${user.userName}</td>
							<td>${user.assignedRole.roleName}</td>
							<td>${user.workingDept.depName}</td>
							<td><a
								href="<spring:url 
							value="/admin/user/edit/${user.userId}"/>" class="btn btn-success"><span><i class="glyphicon glyphicon-pencil"></i></span></a></td>
							<td><a
								href="<spring:url 
							value="/admin/user/delete/${user.userId}"/>" class="btn btn-danger"><span><i class="glyphicon glyphicon-trash"></i></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</body>
</html>
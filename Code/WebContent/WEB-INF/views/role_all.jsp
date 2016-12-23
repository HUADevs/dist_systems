<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Roles</title>
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
				<span class="lead">List of Roles</span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Role ID</th>
						<th>Role Name</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roles}" var="role">
						<tr>
							<td>${role.roleId}</td>
							<td>${role.roleName}</td>
							<td><a
								href="<c:url value='/admin/role/edit/${role.roleId}/${role.roleName}' />"
								class="btn btn-success"><span><i class="glyphicon glyphicon-pencil"></i></span> Edit</a></td>
							<td><a
								href="<c:url value='/admin/role/delete/${role.roleId}' />"
								class="btn btn-danger"><span><i class="glyphicon glyphicon-trash"></i></span> Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>

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
		<div class="row">
			<h1 class="text-center">Add User</h1>
		</div>
	<div class="row">
		<spring:url value="/admin/user/add" var="formUrl" />
		<form:form modelAttribute="user" action="${formUrl }" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div>${msg}</div>
			<div class="form-group">
				<label for="user-firstName">First Name</label>
				<form:errors path="firstName" style="color:red" />
				<form:input id="user-firstName" cssClass="form-control"
					path="firstName" />
			</div>
			<div class="form-group">
				<label for="user-lastName">Last Name</label>
				<form:errors path="lastName" style="color:red" />
				<form:input id="user-lastName" cssClass="form-control"
					path="lastName" />
			</div>
			<div class="form-group">
				<label for="user-emailAdress">Email</label>
				<form:errors path="emailAdress" style="color:red" />
				<form:input id="user-emailAdress" cssClass="form-control"
					path="emailAdress" />
			</div>
			<div class="form-group">
				<label for="user-telephone">Phone</label>
				<form:errors path="telephone" style="color:red" />
				<form:input id="user-telephone" cssClass="form-control"
					path="telephone" />
			</div>
			<div class="form-group">
				<label for="user-roles">Role</label>
				<form:errors path="assignedRole.roleId" style="color:red" />
				<form:select path="assignedRole.roleId" cssClass="form-control">
					<form:options items="${roles}" itemValue="roleId"
						itemLabel="roleName" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="user-departments">Working Department</label>
				<form:errors path="workingDept.id" style="color:red" />
				<form:select path="workingDept.id" cssClass="form-control">
					<form:options items="${departments}" itemValue="id"
						itemLabel="depName" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="user-userName">Username</label>
				<form:errors path="userName" style="color:red" />
				<form:input id="user-userName" cssClass="form-control"
					path="userName" />
			</div>
			<div class="form-group">
				<label for="user-password">Password</label>
				<form:errors path="password" style="color:red" />
				<form:input id="user-password" cssClass="form-control"
					path="password" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

	</div>
	</div>
</body>
</html>
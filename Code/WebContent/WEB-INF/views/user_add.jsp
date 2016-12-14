<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

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

				<div class="form-group">
					<label for="user-firstName">First Name</label>
					<form:errors path="firstName" />
					<form:input id="user-firstName" cssClass="form-control"
						path="firstName" />
				</div>
				<div class="form-group">
					<label for="user-lastName">Last Name</label>
					<form:errors path="lastName" style="color:red"/>
					<form:input id="user-lastName" cssClass="form-control"
						path="lastName" />
				</div>
				<div class="form-group">
					<label for="user-emailAdress">Email</label>
					<form:errors path="emailAdress" />
					<form:input id="user-emailAdress" cssClass="form-control"
						path="emailAdress" />
				</div>
				<div class="form-group">
					<label for="user-telephone">Phone</label>
					<form:input id="user-telephone" cssClass="form-control"
						path="telephone" />
				</div>
				<div class="form-group">
					<label for="user-roles">Role</label>
					<form:select path="assignedRole" cssClass="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${roles}" itemValue="roleId"
							itemLabel="roleName" />
					</form:select>
				</div>
				<div class="form-group">
					<label for="user-departments">Working Department</label>
					<form:select path="workingDept" cssClass="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${departments}" itemValue="id"
							itemLabel="depName" />
					</form:select>
				</div>
				<div class="form-group">
					<label for="user-userName">Username</label>
					<form:errors path="userName" />
					<form:input id="user-userName" cssClass="form-control"
						path="userName" />
				</div>
				<div class="form-group">
					<label for="user-password">Password</label>
					<form:errors path="password" />
					<form:input id="user-password" cssClass="form-control"
						path="password" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>
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
					<label for="user-FirstName">First Name</label>
					<form:errors path="FirstName" />
					<form:input id="user-FirstName" cssClass="form-control"
						path="FirstName" />
				</div>
				<div class="form-group">
					<label for="user-LastName">Last Name</label>
					<form:errors path="LastName" style="color:red"/>
					<form:input id="user-LastName" cssClass="form-control"
						path="LastName" />
				</div>
				<div class="form-group">
					<label for="user-EmailAdress">Email</label>
					<form:errors path="EmailAdress" />
					<form:input id="user-EmailAdress" cssClass="form-control"
						path="EmailAdress" />
				</div>
				<div class="form-group">
					<label for="user-Telephone">Phone</label>
					<form:input id="user-Telephone" cssClass="form-control"
						path="Telephone" />
				</div>
				<div class="form-group">
					<label for="user-roles">Role</label>
					<form:select path="AssignedRole" cssClass="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${roles}" itemValue="RoleId"
							itemLabel="RoleName" />
					</form:select>
				</div>
				<div class="form-group">
					<label for="user-roles">Working Department</label>
					<form:select path="WorkingDept" cssClass="form-control">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${departments}" itemValue="id"
							itemLabel="DepName" />
					</form:select>
				</div>
				<div class="form-group">
					<label for="user-UserName">Username</label>
					<form:errors path="UserName" />
					<form:input id="user-UserName" cssClass="form-control"
						path="UserName" />
				</div>
				<div class="form-group">
					<label for="user-Password">Password</label>
					<form:errors path="Password" />
					<form:input id="user-Password" cssClass="form-control"
						path="Password" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>
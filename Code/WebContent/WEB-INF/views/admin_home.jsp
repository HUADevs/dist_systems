<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../views/fragments/admin-header.jsp"></jsp:include>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">Hello, admin!</h1>
			<p>From this console you can create, edit and remove users , roles and services supported by your website.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="https://drive.google.com/file/d/0B9erbBG0AbgAZ0UtbE1LdndPc1U/view?usp=sharing">Learn
					more »</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Manage Users</h2>
				<p>Add a new user. Edit and delete existing users.</p>
				<p>
					<a class="btn btn-secondary" href="<spring:url value="/admin/user/add"/>" role="button">Add »</a> 
					<a class="btn btn-secondary" href="<spring:url value="/admin/user/view"/>" role = "button">Edit »</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Manage Roles</h2>
				<p>Create a new role. Edit and delete existing roles.</p>
				<p>
					<a class="btn btn-secondary" href="<spring:url value="/admin/role/add"/>" role="button" >Add
						»</a> <a class="btn btn-secondary" href="<spring:url value="/admin/role/view"/>" role="button">Edit »</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Manage Services</h2>
				<p>Create a new service. Edit and delete existing services.</p>
				<p>
					<a class="btn btn-secondary" href="<spring:url value="/admin/service/add"/>" role="button" >Add »</a> <a
						class="btn btn-secondary" href="<spring:url value="/admin/service/view"/>" role="button">Edit »</a>
				</p>
			</div>
		</div>

		<hr>
	</div>
	<!-- /container -->

</body>
</html>
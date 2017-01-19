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

	<jsp:include page="../views/fragments/cms-header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Add User</h1>
		</div>
		<div class="row">
			<spring:url value="/cms/insurance/${insurance.id}/adduser"
				var="formUrl" />
			<form:form modelAttribute="user" action="${formUrl }" method="post"
				cssClass="col-md-8 col-md-offset-2">
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
				<a href='<spring:url value="/cms/insurance/view"></spring:url>' class="btn btn-default btn-lg">Skip</a>
				<button type="submit" class="btn btn-success btn-lg">Save</button>
			</form:form>
			

		</div>
	</div>
</body>
</html>
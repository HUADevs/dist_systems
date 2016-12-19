<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Role</title>
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
			<h1 class="text-center">Edit Role</h1>
		</div>
		<div class="row">
			<spring:url value="/admin/role/edit/${role.roleId}" var="formUrl" />
			<form:form modelAttribute="role" action="${formUrl }" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="role-roleName">Role Name</label>
					<form:errors path="roleName" style="color:red"/>
					<form:input id="role-roleName" cssClass="form-control"
						path="roleName" />
				</div>
				
				<div class="form-group">
					<label for="role-services">Select supported Services</label> <br/>
					<form:checkboxes id="role-services" path="services" items="${listservices}" itemValue="serviceName" itemLabel="serviceName" delimiter="<br/>"/>
				</div>
				
				
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>
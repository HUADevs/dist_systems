<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>
	
	<div class="container">
		<div class="row">
			
				<div class="form-group">
					<label for="user-name">Name</label>
					<span>${user.FirstName}</span>
					<span>${user.LastName}</span>
				</div>

				<div class="form-group">
					<label for="user_EmailAdress">Type</label>
					<span>${user.EmailAdress }</span>
				</div>
							
				<div class="form-group">
					<label for="user_username">Username</label>
					<span>${user.UserName}</span>
				</div>
			
		</div>
	</div>
</body>
</html>
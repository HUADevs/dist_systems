<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Insurance</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-select.min.css"/>"
	type="text/css" />
<link href="/resources/css/common.css" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
</head>
<body>
	<jsp:include page="../views/fragments/cms-header.jsp"></jsp:include>


	<div class="container">
		<div class="row">
			<h1 class="text-center">Create New Insurance</h1>
		</div>
		<div class="jumbotron">
			<section>
				<h2 class="text-center">
					<strong>Customer Details</strong>
				</h2>
				<ul class="list-group">
					<li class="list-group-item list-group-item-success"><strong>Name:</strong>
						${customer.firstName} ${customer.lastName }</li>
					<li class="list-group-item list-group-item-success"><strong>Personal
							Id:</strong> ${customer.personalId }</li>
					<li class="list-group-item list-group-item-success"><strong>Tax
							Registration Number:</strong> ${customer.trn }</li>
					<li class="list-group-item list-group-item-success"><strong>License
							Date:</strong> ${customer.licenseAqquired }</li>
				</ul>
			</section>
			<section>
				<h2 class="text-center">
					<strong>Vehicle Details</strong>
				</h2>
				<ul class="list-group">
					<li class="list-group-item list-group-item-danger"><strong>License
							Plate:</strong> ${vehicle.licensePlate}</li>
					<li class="list-group-item list-group-item-danger"><strong>Release
							Date:</strong> ${vehicle.releaseDate }</li>
					<li class="list-group-item list-group-item-danger"><strong>Cubic:</strong>
						${vehicle.cubic }cc</li>
					<li class="list-group-item list-group-item-danger"><strong>Type:</strong>
						${vehicle.type }</li>
					<li class="list-group-item list-group-item-danger"><strong>Color:</strong>
						${vehicle.color }</li>
				</ul>
			</section>
			<section>
				<h2 class="text-center">
					<strong>Choose Type of Insurance</strong>
				</h2>
				<form:form>
					<button type="submit" class="btn btn-primary btn-lg center-block">Add</button>
				</form:form>
			</section>
		</div>
	</div>

</body>
</html>
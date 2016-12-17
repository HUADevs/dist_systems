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
				<ul class="previewList">
					<li>Name: ${customer.firstName} ${customer.lastName }</li>
					<li>Personal Id: ${customer.personalId }</li>
					<li>Tax Registration Number: ${customer.trn }</li>
					<li>License Date: ${customer.licenseAqquired }</li>
				</ul>
			</section>
			<section>
				<h2 class="text-center">
					<strong>Vehicle Details</strong>
				</h2>
				<ul class="previewList">
					<li>License Plate: ${vehicle.licensePlate}</li>
					<li>Release Date: ${vehicle.releaseDate }</li>
					<li>Cubic: ${vehicle.cubic }cc</li>
					<li>Type: ${vehicle.type }</li>
					<li>Color: ${vehicle.color }</li>
				</ul>
			</section>
		</div>
	</div>

</body>
</html>
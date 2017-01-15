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
			<h1 class="text-center">Create New Insurance</h1>
		</div>
		<div class="jumbotron container-fluid">
			<section>
				<h2 class="text-center">
					<strong>Customer Details</strong>
				</h2>
				<ul class="list-group">
					<li class="list-group-item list-group-item-success"><strong>Name:</strong>
						${customer.firstName} ${customer.lastName }</li>
					<li class="list-group-item list-group-item-success"><strong>Personal
							Id:</strong> ${customer.personalId }</li>
					<li class="list-group-item list-group-item-success"><strong>Date
							of Birth:</strong> ${customer.birthdayDate }</li>
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
				<spring:url value="/cms/insurance/${id}/review" var="formUrl" />
				<form:form modelAttribute="insurance" action="${formUrl}"
					method="post" cssClass="col-md-8 col-md-offset-2">
					<div class="form-group">
						<form:errors path="type" style="color:red" />
						<br>
						<form:radiobuttons path="type" items="${typeOptions}" />
					</div>
					<div class="form-group">
						<label for="duration">Duration of Contract (In Years)</label>
						<form:errors path="duration" style="color:red" />
						<form:radiobuttons id="duration" path="duration"
							items="${durationOptions}" />
					</div>
					<c:choose>
						<c:when test="${insurance.newDriver }">
							<div class="form-group">
								<span>Driver under 23 is detected</span>
							</div>
						</c:when>
						<c:otherwise>
							<div class="form-group">
								<label for="newDriver">Driver under 23</label>
								<form:checkbox id="newDriver" value="checkValue"
									path="newDriver" />
							</div>
						</c:otherwise>
					</c:choose>
					<button type="submit" class="btn btn-primary btn-lg center-block">Add</button>
				</form:form>
			</section>
		</div>
	</div>

</body>
</html>
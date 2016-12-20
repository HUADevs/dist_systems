<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Declare Damage</title>
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
			<h1 class="text-center">Declare Damage</h1>
			<h6 class="text-center">for Vehicle: ${dform.licensePlate.licensePlate }</h6>
		</div>
	<div class="row">
		<spring:url value="/cms/damage/declare" var="formUrl" />
		<form:form modelAttribute="dform" action="${formUrl }" method="post"
			cssClass="col-md-8 col-md-offset-2">
			<div>${msg}</div>
			<div class="form-group">
				<label for="dform-description">Description</label>
				<form:errors path="damageDescription" style="color:red" />
				<form:textarea id="dform-description" cssClass="form-control"
					path="damageDescription" />
			</div>
			<div class="form-group">
				<label for="dform-cost">Cost</label>
				<form:errors path="damageCost" style="color:red" />
				<form:input id="dform-cost" cssClass="form-control"
					path="damageCost" />
			</div>
			
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>

	</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Find Vehicle</title>
</head>
<body>
	<jsp:include page="../views/fragments/cms-header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<h1 class="text-center">Find Vehicle</h1>
		</div>
		<div class="row">
			<spring:url value="/cms/insurance/findVehicle" var="formUrl" />
			<form:form modelAttribute="vehicle" action="${formUrl}" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="customer-vehicle">License Plate</label>
					<form:errors path="licensePlate" />
					<form:input id="customer-vehicle" cssClass="form-control"
						path="licensePlate" />
				</div>
				<button type="submit" class="btn btn-default">Search</button>
			</form:form>

		</div>
	</div>
</body>
</html>
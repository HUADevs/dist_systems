<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Vehicle</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">Find Vehicle</h1>
		</div>
		<div class="row">
			<spring:url value="/cms/insurance/findVehicle" var="formUrl" />
			<form:form modelAttribute="vehicle" action="${formUrl}"
				method="post" cssClass="col-md-8 col-md-offset-2">

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
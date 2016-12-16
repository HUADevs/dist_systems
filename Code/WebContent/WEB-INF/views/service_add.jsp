<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Service</title>
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
			<h1 class="text-center">Add a new Service</h1>
		</div>
		<div class="row">
			<spring:url value="/admin/service/add" var="formUrl" />
			<form:form modelAttribute="service" action="${formUrl }" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="service-ServiceName">Service Name</label>
					<form:errors path="serviceName"/>
					<form:input id="service-ServiceName" cssClass="form-control"
						path="serviceName" />
				</div>
	
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>
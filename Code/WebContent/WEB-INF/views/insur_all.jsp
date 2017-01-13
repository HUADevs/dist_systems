<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Insurances</title>
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
			<spring:url value="/cms/insurance/view" var="formUrl" />
			<form:form modelAttribute="search" action="${formUrl }" method="post"
				cssClass="col-md-8 col-md-offset-2">
				<div>${msg}</div>
				<div class="form-group">
					<form:errors path="licensePlate" style="color:red" />
					<div class="input-group col-xs-10 col-md-12">
						<form:input id="ins-search" cssClass="form-control"
							placeholder="Search a specific insurance" path="licensePlate" />

						<div class="input-group-btn">
							<button type="submit" class="btn btn-primary">
								<span><i class="glyphicon glyphicon-search"></i></span>
							</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<br />
	</div>
	<div class="container">
		<div class="row">
			<div class="panel panel-info">
				<!-- Default panel contents -->
				<div class="panel-heading text-center">
					<span class="lead">List of Insurances</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>License Plate</th>
							<th>Type</th>
							<th>Start At</th>
							<th>Duration</th>
							<th>Ends At</th>
							<th>New Driver</th>
							<th>Price</th>
							<th>Paid</th>
							<th width="100"></th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
					<tbody>
						<c:forEach items="${insurances}" var="insurance">
							<tr>
								<td>${insurance.licensePlate.customerPersonID.firstName}
									${insurance.licensePlate.customerPersonID.lastName}</td>
								<td>${insurance.licensePlate.licensePlate}</td>
								<td>${insurance.type}</td>
								<td>${insurance.insuranceDate}</td>
								<td>${insurance.duration}(Year/s)</td>
								<td>${insurance.expirationDate}</td>
								<td>${insurance.newDriver}</td>
								<td>${insurance.price}&euro;</td>
								<td>${insurance.paid}</td>
								<td><a
									href="<spring:url
							value="/cms/insurance/${insurance.id}/delete"/>"
									class="btn btn-danger"><span><i
											class="glyphicon glyphicon-trash"></i></span> Delete</a></td>
								<c:choose>
									<c:when test="${insurance.expired}">
										<td><a
											href="<spring:url
							value="/cms/insurance/${insurance.id}/edit"/>"
											class="btn btn-success"><span><i
													class="glyphicon glyphicon-list-alt"></i></span> Expand/Update</a></td>
									</c:when>
									<c:otherwise>
										<td><a
											href="<spring:url
							value="/cms/damage/declare/${insurance.licensePlate.licensePlate}"/>"
											class="btn btn-warning"><span><i
													class="glyphicon glyphicon-list-alt"></i></span> Declare Damage</a></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</body>
</html>
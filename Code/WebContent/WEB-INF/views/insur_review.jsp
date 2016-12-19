<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Insurance</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="../views/fragments/cms-header.jsp"></jsp:include>
	<style>
hr {
	border: 0;
	border-top: 1px solid #8c8c8c;
	border-bottom: 1px solid #fff;
}
</style>
	<div class="container">
		<div class="row">
			<h1 class="text-center">Review Insurance</h1>
		</div>
		<div class="jumbotron">
			<div class="row">
				<div
					class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
					<div class="panel panel-primary panel-table">
						<div class="panel-heading">
							<div class="tr">
								<div class="td text-center lead">Detailed Presentation</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="tr">
								<section>
									<p>
										Name: <strong>${customer.firstName}
											${customer.lastName}</strong>
									</p>
									<p>
										Vehicle: <strong>${vehicle.licensePlate}</strong>
									</p>
									<p>
										Insurance Type: <strong>${insurance.type}</strong>
									</p>
									<p>
										Insurance Start at: <strong>${insurance.insuranceDate}</strong>
									</p>
									<p>
										Duration(Years): <strong>${insurance.duration}</strong>
									</p>
									<c:choose>
										<c:when test="${insurance.newDriver}">
											<p>
												New Driver: <strong>Yes</strong>
											</p>
										</c:when>
										<c:otherwise>
											<p>
												New Driver: <strong>No</strong>
											</p>
										</c:otherwise>
									</c:choose>
									<hr>
									<dl class="lead">
										<dt>Initial Cost: ${insurance.price / (1-insurance.discount)}&euro;</dt>
										<dd>- Discount:${(insurance.price / (1-insurance.discount)) - insurance.price}&euro;</dd>
									</dl>
								</section>
							</div>
						</div>
						<div class="panel-footer panel-primary">
							<div class="tr">
								<div class="td">
									<p class="lead text-right">Final Cost = ${insurance.price}
										euros</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div
					class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
					<a href="<c:url value='/cms/insurance/${insurance.id}/delete' />"
						class="btn btn-danger btn-lg">Cancel</a> <a
						href="<c:url value='/cms/insurance/${insurance.id}/edit' />"
						class="btn btn-warning btn-lg">Edit</a>
					<button type="submit" class="btn btn-success btn-lg pull-right">Save</button>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
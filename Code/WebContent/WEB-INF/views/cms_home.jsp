<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../views/fragments/cms-header.jsp"></jsp:include>
	<div class="jumbotron">
		<div class="container">
		<sec:authorize access="isAuthenticated()">
			<h2 class="display-3">
				Hello,
				<sec:authentication property="principal.username" />
				!
			</h2>
		</sec:authorize>
			<p>From this console you can create, edit and remove insurances.
				You can declare or edit a damage incident and approve or decline a
				pending damage incident request (if you have the authority).</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#">Learn more »</a>
			</p>
		</div>
	</div>
	<div class="container">
		<h2 class="text-center">Available Insurance Packages</h2>
		<br>
		<div class="row">
			<div class="col-md-4">
				<div class="panel panel-primary panel-table">
					<div class="panel-heading">
						<div class="tr">
							<div class="td text-center lead">Basic Package</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="tr">
							<section>
							<h4></h4>
								<ul>
									<li>Automobile Liability</li>
									<li>Coverage by an uninsured vehicle</li>
									<li>Legal protection</li>
									<li>24/7 Health Line</li>
									<li>Accident care</li>
								</ul>
								<br><br><br><br>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-primary panel-table">
					<div class="panel-heading">
						<div class="tr">
							<div class="td text-center lead">Intermediate Package</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="tr">
							<section>
								<h4 class="text-center">Basic Package</h4>
								<h4 class="text-center">+</h4>
								<ul>
									<li>Full Roadside Assistance</li>
									<li>Fire</li>
								</ul>
								<br><br><br><br>
							</section>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="panel panel-primary panel-table">
					<div class="panel-heading">
						<div class="tr">
							<div class="td text-center lead">Premium Package</div>
						</div>
					</div>
					<div class="panel-body">
						<div class="tr">
							<section>
								<h4 class="text-center">Intermediate Package</h4>
								<h4 class="text-center">+</h4>
								<ul>
									<li>Natural phenomena</li>
									<li>Terrorist actions</li>
									<li>Total theft</li>
									<li>Partial theft</li>
									<li>Crystal breakage</li>
									<li>Personal driver accident</li>
								</ul>
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="jumbotron">
		<div class="container">
			<!-- Example row of columns -->
			<div class="row">
				<div class="col-md-4">
					<h2>Manage Insurances</h2>
					<p>Add a new insurance. Edit and delete existing insurances.</p>
					<p>
						<a class="btn btn-secondary"
							href="<spring:url value="/cms/insurance/findVehicle"/>"
							role="button">Add »</a> <a class="btn btn-secondary"
							href="<spring:url value="/cms/insurance/view"/>" role="button">Edit
							»</a>
					</p>
				</div>
				<div class="col-md-4">
					<h2>Manage Damage Incidents</h2>
					<p>Declare a new Damage Incident Form. Edit existing forms.</p>
					<p>
						<a class="btn btn-secondary"
							href="<spring:url value="/cms/insurance/view"/>" role="button">Add
							»</a> <a class="btn btn-secondary"
							href="<spring:url value="/cms/damage/view"/>" role="button">Edit
							»</a>
					</p>
				</div>
				<sec:authorize access="hasAnyAuthority('Damage Approval more than 2000', 'Damage Approval 300-2000')">
					<div class="col-md-4">
						<h2>Approve Damage Forms</h2>
						<p>Approve or deny a damage form.</p>
						<p>
							<a class="btn btn-secondary"
								href="<spring:url value="/cms/damage/view/specific"/>"
								role="button">Check »</a>
						</p>
					</div>
				</sec:authorize>
			</div>
			<hr>
		</div>
	</div>
	<!-- /container -->
</body>
</html>
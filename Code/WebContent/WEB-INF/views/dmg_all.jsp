<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Damage Forms</title>
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
			<div class="panel panel-info">
				<!-- Default panel contents -->
				<div class="panel-heading text-center">
					<span class="lead">List of Damage Forms</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>License Plate</th>
							<th>Cost</th>
							<th>Approved</th>
							<th>Date Added</th>
							<th width="100"></th>
						</tr>
					</thead>
					<tbody>
					<tbody>
						<c:forEach items="${dmg_forms}" var="dmg">
							<tr>
								<td>${dmg.id}</td>
								<td>${dmg.licensePlate.licensePlate}</td>
								<td>${dmg.damageCost}<i class="glyphicon glyphicon-euro"></i></td>
								<td><span><c:choose>
											<c:when test="${dmg.approval == true}">
												<i class="glyphicon glyphicon-ok" style="color:green"></i>
											</c:when>
											<c:otherwise>
												<i class="glyphicon glyphicon-remove" style="color:red"></i>
											</c:otherwise>
										</c:choose></span></td>
								<td>${dmg.dateAdded}</td>
								<td><a
									href="<spring:url
							value="/cms/dmg/${dmg.id}/review"/>"
									class="btn btn-success"><span><i
											class="glyphicon glyphicon-pencil"></i></span> Review</a></td>
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
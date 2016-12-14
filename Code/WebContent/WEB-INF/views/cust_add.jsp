<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new insurance</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1 class="text-center">Add Customer</h1>
		</div>
		<div class="row">
			<spring:url value="/cms/insurance/findCustomer" var="formUrl" />
			<form:form modelAttribute="customer" action="${formUrl}" method="post"
				cssClass="col-md-8 col-md-offset-2">

				<div class="form-group">
					<label for="customer-personalId">Personal ID</label>
					<form:errors path="PersonalId" />
					<form:input id="user-FirstName" cssClass="form-control"
						path="FirstName" />
				</div>
				<div class="form-group">
					<label for="user-LastName">Last Name</label>
					<form:errors path="LastName" />
					<form:input id="user-LastName" cssClass="form-control"
						path="LastName" />
				</div>
				<div class="form-group">
					<label for="user-EmailAdress">Email</label>
					<form:errors path="EmailAdress" />
					<form:input id="user-EmailAdress" cssClass="form-control"
						path="EmailAdress" />
				</div>
				<div class="form-group">
					<label for="user-Telephone">Phone</label>
					<form:input id="user-Telephone" cssClass="form-control"
						path="Telephone" />
				</div>
				<div class="form-group">
					<label for="user-roles">Role</label>
					<form:select path="AssignedRole" cssClass="form-control"
						items="${roles}"></form:select>
				</div>
				<div class="form-group">
					<label for="user-roles">Working Department</label>
					<form:select path="WorkingDept" cssClass="form-control"
						items="${departments}"></form:select>
				</div>
				<div class="form-group">
					<label for="user-UserName">Username</label>
					<form:errors path="UserName" />
					<form:input id="user-UserName" cssClass="form-control"
						path="UserName" />
				</div>
				<div class="form-group">
					<label for="user-Password">Password</label>
					<form:errors path="Password" />
					<form:input id="user-Password" cssClass="form-control"
						path="Password" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>

		</div>
	</div>
</body>
</html>
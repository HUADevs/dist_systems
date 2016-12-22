<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Log in with your account</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href='<spring:url value="/resources/css/login.css"></spring:url>'
	rel="stylesheet">
</head>

<body>

	<div class="container">

		<form method="POST" action='<spring:url value="/login"></spring:url>'
			class="form-signin">
			<h2 class="form-heading">Log in</h2>

			<div class="form-group ${error != null ? 'has-error' : ''}">
				<c:if test="${message!=null}">
					<br>
					<span class="alert alert-success" role="alert">${message}</span>
					<br>
					<br>
				</c:if>
				<input name="username" type="text" class="form-control"
					placeholder="Username" /> <input name="password" type="password"
					class="form-control" placeholder="Password" />
				<c:if test="${error!=null }">
					<br>
					<span class="alert alert-danger" role="alert">${error}</span>
					<br>
					<br>
				</c:if>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<button class="btn btn-lg btn-primary btn-block" type="submit">Log
					In</button>
			</div>

		</form>

	</div>
</body>
</html>
<%@ page language="java" isErrorPage="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<title>Error page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<spring:url value='/resources/css/404-custom.css'/>"> 
</head>
<body>
	
	<div class="text-wrapper">
		<div class="title" data-content="404">404 Page Not Found</div>

		<div class="subtitle">Oops, I think you are lost mate!.</div>

		<button class="btn btn-danger center-block" onclick="history.back()">Back
			to Previous Page</button>
	</div> -->
</body>
</html>

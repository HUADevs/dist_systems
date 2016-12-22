<%@ page language="java" isErrorPage="true"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<title>Error page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Droid+Sans'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Allerta+Stencil'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="<spring:url value='/resources/css/403-custom.css'/>">
</head>
<body>
	<div id="title">
		<span class="red">4</span><span id="do-not"> <span
			class="hole one"></span> <span class="hole two"></span>
		</span> <span class="red">3</span>
	</div>
	<p>You have been caught!</p>
	<p>Request permission to access / on this server.</p>
	<button class="btn center-block" style="background-color: #f22; color:white" onclick="history.back()">Back
		to Previous Page</button>
</body>
</html>
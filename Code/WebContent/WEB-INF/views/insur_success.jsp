<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
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
			<div class="jumbotron">
				<h1 class="lead text-center">Success</h1>
				<p class="text-center">Insurance with number protocol
					${insurance.id} has been successfully inserted to the system!</p>
			</div>
		</div>
	</div>
</body>
</html>
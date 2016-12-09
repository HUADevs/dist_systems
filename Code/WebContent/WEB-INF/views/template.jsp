<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<%@ page session="false"%>
<html>
<head>
<title>Customer Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a Customer</h1>

	<spring:url var="addAction" value="/cms/customer/add"></spring:url>

	<form:form action="${addAction}" method="post" modelAttribute="customer">
		<table>
			<%-- <tr>
				<td><form:label path="id">
						<spring:message text="ID" />
					</form:label></td>
				<td><form:input path="id" readonly="true" size="8"
						disabled="true" /> <form:hidden path="id" /></td>
			</tr> --%>
			<tr>
				<td><form:label path="FirstName">
						<spring:message text="FirstName" />
					</form:label></td>
				<td><form:input path="FirstName" /></td>
			</tr>
			<tr>
				<td><form:label path="LastName">
						<spring:message text="LastName" />
					</form:label></td>
				<td><form:input path="LastName" /></td>
			</tr>
			<tr>
				<td><form:label path="PersonalId">
						<spring:message text="PersonalId" />
					</form:label></td>
				<td><form:input path="PersonalId" /></td>
			</tr>
			<tr>
				<td><form:label path="TRN">
						<spring:message text="TRN" />
					</form:label></td>
				<td><form:input path="TRN" /></td>
			</tr>
			<tr>
				<td><form:label path="LicenseAqquired">
						<spring:message text="LicenseAqquired" />
					</form:label></td>
				<td><form:input path="LicenseAqquired" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add Customer"/>" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
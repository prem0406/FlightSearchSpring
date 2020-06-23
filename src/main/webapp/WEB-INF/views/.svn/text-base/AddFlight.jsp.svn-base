<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add team page</h1>
	<p>Here you can add a new team.</p>
	<form:form method="POST" commandName="flight"
		action="flight/add/process">

		<table>
			<tbody>
				<tr>
					<td>Number:</td>
					<td><form:input path="flightNumber"></form:input></td>
				</tr>
				<tr>
					<td>Departure Location:</td>
					<td><form:input path="departureLocation"></form:input></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>

	<p>
		<a href="/home">Home page</a>
	</p>
</body>
</html>
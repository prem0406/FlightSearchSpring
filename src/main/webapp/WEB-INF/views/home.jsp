<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>"
	type="text/css" />


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/home.css"/>"
	type="text/css" />

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>
<body>

	<%@include file="header.jsp"%>



	<div id="content-wrapper">
		<h2 id="welcome-title">Welcome to Flight Search Home Page.</h2>

		<div id="center-region">
			<div id="search-region">
				<fieldset id="fieldset-search">
					<legend>Enter Search Input Parameters:</legend>

					<!-- if session for the user not exists or expires,redirect to login page -->
					<c:if
						test="${(loggedinUser == null) || (fn:length(loggedinUser)<=0)}">
						<c:redirect url="/login"></c:redirect>
					</c:if>

					<form:form method="post" commandName="flightSearchParams"
						action="search-flight">
						<div id="div-departure-location">
							<form:label path="departureLocation" class="label">Departure Location:</form:label>
							<form:input path="departureLocation" size="20" id="input-text" />
							<form:errors path="departureLocation" cssClass="error"
								element="div" />
						</div>

						<div id="div-flight-date">
							<form:label path="flightDate" class="label">Departure Date:</form:label>
							<form:input path="flightDate" size="10" id="datepicker" />
							<%-- <form:errors path="flightDate" cssClass="error" element="div" /> --%>
						</div>
						<div id="div-arrival-location" class="margin-top">
							<form:label path="arrivalLocation" class="label">Arrival Location:</form:label>
							<form:input path="arrivalLocation" size="20" id="input-text" />
							<form:errors path="arrivalLocation" cssClass="error"
								element="div" />
						</div>


						<div id="div-flight-class" class="margin-top">
							<form:label path="flightClass" class="label">Flight Class:</form:label>
							<form:input path="flightClass" size="5" id="input-text" />
							<form:errors path="flightClass" cssClass="error" element="div" />
						</div>
						<div id="div-output-preference" class="margin-top">
							<form:label path="outputPreference" class="label">Output Preference:</form:label>
							<form:input path="outputPreference" size="5" id="input-text" />
							<small>(0-sort using fare, 1-sort using duration)</small>
							<form:errors path="outputPreference" cssClass="error"
								element="div" />
						</div>
						<div id="div-submit">
							<input type="submit" value="Search" id="btn-submit" />
						</div>
					</form:form>

				</fieldset>
			</div>

		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
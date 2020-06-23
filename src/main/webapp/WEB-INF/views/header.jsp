<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>"
	type="text/css" />

</head>
<body>

	<div id="header-wrapper">
		<div id="header-title">Flight Search</div>
		<div id="user-name-logout">
			<p>Welcome, ${loggedinUser}</p>
			<div id="logout">
				<a href="logout">logout</a>
			</div>
		</div>



	</div>
</body>
</html>
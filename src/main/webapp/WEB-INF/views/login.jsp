<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/common.css"/>"
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"
	type="text/css" />


<title>Login</title>
</head>
<body>
	<%@include file="header.jsp"%>

	<div id="content-wrapper">
		<div id="login">
			<form:form action="verify-login" commandName="login" method="post">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table>
					<tr>
						<td><form:label path="username">Username</form:label></td>
						<td><form:input path="username" id="field-username"
								size="30px" /></td>
					</tr>

					<tr>
						<td><form:label path="password">Password</form:label></td>
						<td><form:password path="password" id="field-password"
								size="30px" /></td>
					</tr>

					<tr>
						<td colspan="2"><input type="submit" value="Login"
							id="btn-submit" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>


	<%@include file="footer.jsp"%>
</body>
</html>
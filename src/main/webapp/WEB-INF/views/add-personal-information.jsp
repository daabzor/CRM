<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Creating account</title>
</head>
<body>
<p>
		<font color="blue">${createAccountInfo}</font>
	</p>
	<h1>Hey there ${user.userName}. Enter your personal information
		below to create account :</h1>

	<form:form action="/create-account/add-personal-info" modelAttribute="personalInfo" method="POST">
		<table border="1">
			<tbody>
				<tr>
					<th>First name:</th>
					<td><form:input type="text" path="firstName" id="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error"/></td>
				</tr>
				
				<tr>
					<th>Last name:</th>
					<td><form:input type="text" path="lastName" id="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error"/></td>
				</tr>
				
				<tr>
					<th>E-mail:</th>
					<td><form:input type="text" path="email" id="email" /></td>
						<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				
				<tr>
					<th>Country:</th>
					<td><form:input type="text" path="city" id="city" /></td>
						<td><form:errors path="city" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td colspan="2" align="right"><input type="submit" name="action" value="Create account!" /></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	<a href="/login">Click here</a> to show login page.
</body>
</html>
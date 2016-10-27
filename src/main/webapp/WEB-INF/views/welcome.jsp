<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<h1>Welcome ${personalInfo.firstName}. You are now authenticated. Your
	personal information below:</h1>
	
	<table border="1">
		<th>User</th>
		<th>First name</th>
		<th>Last name</th>
		<th>E-mail</th>
		<th>City</th>
		<tr>
			<td>${user.userName}</td>
			<td>${personalInfo.firstName}</td>
			<td>${personalInfo.lastName}</td>
			<td>${personalInfo.email}</td>
			<td>${personalInfo.city}</td>
		</tr>
	</table>

	<h2>Personal information:</h2>

	<form:form action="personalInfo" method="POST" modelAttribute="personalInfo">
		<table>
			<tr>
				<td>First name</td>
				<td><form:input type="text" path="firstName" id= "firstName"/></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><form:input path="lastName" /><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><form:input path="email" /><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:input path="city" /><form:errors path="city" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="action" value="Edit" />
				</td>
			</tr>
		</table>
	</form:form>
	
	<a href="/add-friends">Click here</a> to add friends.
	
</body>
</html>
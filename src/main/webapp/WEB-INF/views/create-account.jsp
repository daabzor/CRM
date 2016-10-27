<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Creating account</title>
</head>
<body>
	<p>
		<font color="red">${errorLoginVerification}</font>
	</p>
	<p>
		<font color="red">${errorPassword}</font>
	</p>
	
	<H1>Create account:</H1>
	<form:form action="/create-account" method="POST" modelAttribute="user">
		<table border="1">
			<tbody>
			
				<tr>
					<th>User name:</th>
					<td><form:input type="text" path="userName" id="userName" /></td>			
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				
				<tr>
					<th>Password:</th>
					<td><form:input type="password" path="userPassword" id="userPassword" /></td>
					<td><form:errors path="userPassword" cssClass="error" /></td>
				</tr>
				
				<tr>
					<th>Confirm password:</th>
					<td><input type="password" name="confirmedPassword" /></td>
				</tr>
				
				<tr>
					<td colspan="2" align="right"><input type="submit" value="Check availbility!" /></td>
				</tr>
				
			</tbody>
		</table>
	</form:form>
	
	<a href="/login">Click here</a> to show login page.

</body>
</html>
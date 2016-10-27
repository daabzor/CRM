<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login page</title>
</head>

<body>
<p><font color="red">${errorUser}</font></p>
<p><font color="red">${errorPassword}</font></p>
<H1>Log in</H1>
<form:form action="/login/singup" method="POST" modelAttribute="user">
			<table border="1">
				<tbody>
					<tr>
						<th>User name: </th>
						<td><form:input type="text" path="userName" /></td><c:if test="${pageContext.request.method=='POST'}"><td><form:errors path="userName" /></td></c:if>
					</tr>
					<tr>
						<th>Password: </th>
						<td><form:input type="password" path="userPassword" /></td><c:if test="${pageContext.request.method=='POST'}"><td><form:errors path="userPassword" /></td></c:if>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="Log in!" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<a href="/">Click here</a> to show home page.
</body>
</html>
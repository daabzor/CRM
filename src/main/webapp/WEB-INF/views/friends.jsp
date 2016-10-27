<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<h1> ${user.userName} You can add friends below:</h1>
	
	<a href="<c:url value='/add-friends/clear' />" >Clear</a>
	<form:form action="/add-friends/editFriend" method="POST" modelAttribute="friend">
		<table>
			<td><form:hidden path="friendId" /></td>
			<tr>
				<td>First name:</td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><form:input path="lastName" /><form:errors path="lastName" cssClass="error"/></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><form:input path="email" /><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Phone number:</td>
				<td><form:input path="phoneNumber" /><form:errors path="phoneNumber" cssClass="error"/></td>
			</tr>
			<tr>
			<c:if test="${!empty friend.firstName}">
				<td colspan="2"><input type="submit" name="action" value="Edit" />
				</td>
				</c:if>
				<c:if test="${empty friend.firstName}">
				<td colspan="2"><input type="submit" name="action" value="Add" />
				</td>
				</c:if>
			</tr>
		</table>
	</form:form>
	
	
	<table border="1">
	<th>First name</th>
	<th>Last name</th>
	<th>E-mail</th>
	<th>Phone number</th>
	<th>Edit</th>
	<th>Delete</th>
	<c:forEach items="${friendsList}" var="friends">
		<tr>
			<td>${friends.firstName}</td>
			<td>${friends.lastName}</td>
			<td>${friends.email}</td>
			<td>${friends.phoneNumber}</td>
			<td><a href="<c:url value='/add-friends/edit/${friends.friendId}' />" >Edit</a></td>
			<td><a href="<c:url value='/add-friends/delete/${friends.friendId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
</table>
<a href="/login">Click here</a> to back to login page.
</body>
</html>
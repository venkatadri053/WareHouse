<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2 style="color: red">Welcome To WhUserData Page</h2>
<a href="excel">Excel Export</a> |
<a href="pdf">PDF Export</a>
<table border="1">
		<tr>
			<th>USER ID</th>
			<th>USER TYPE</th>
			<th>USER CODE</th>
			<th>USER FOR</th>
			<th>USER EMAIL</th>
			<th>USER CONTACT</th>
			<th>USER IDTYPE</th>
			<th>IFOTHER</th>
			<th>IDNUM</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.userType}" /></td>
				<td><c:out value="${user.userCode}" /></td>
				<td><c:out value="${user.userFor}" /></td>
				<td><c:out value="${user.userEmail}" /></td>
				<td><c:out value="${user.userContact}" /></td>
				<td><c:out value="${user.userIdType}" /></td>
				<td><c:out value="${user.ifOther}" /></td>
				<td><c:out value="${user.idNum}" /></td>
				
				<td><a href="delete?id=${user.id}">DELETE</a></td>
				<td><a href="edit?id=${user.id}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>


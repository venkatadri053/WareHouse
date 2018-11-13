<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2 style="color: red">Welcome To OrderMetod Data Page</h2>
	<a href="excel">Excel Export</a> |
	<a href="pdf">PDF Export</a>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>ORDERMODE</th>
			<th>ORDER CODE</th>
			<th>ORDER METHOD</th>
			<th>ORDER ACCEPT</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="ord">
			<tr>
				<td><c:out value="${ord.id}" /></td>
				<td><c:out value="${ord.mode}" /></td>
				<td><c:out value="${ord.code}" /></td>
				<td><c:out value="${ord.method}" /></td>
				<td><c:out value="${ord.accept}" /></td>
				<td><c:out value="${ord.dsc}" /></td>
				<td><a href="delete?id=${ord.id}">DELETE</a></td>
				<td><a href="edit?id=${ord.id}">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>
	${message}
</body>
</html>


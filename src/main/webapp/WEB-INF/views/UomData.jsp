<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2 style="color:red">Welcome To Uom Data Page</h2>

<a href="excel">Excel Export</a>   |   <a href="pdf">PDF Export</a>

<table border="1">
<tr style="background-color:yellowgreen;color:white;">
<th>ID</th>
<th>TYPE</th>
<th>MODEL</th>
<th>DESCRIPTION</th>
<th colspan="2">CRUD-OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="uom">
<tr>
<td><c:out value="${uom.id}"/></td>
<td><c:out value="${uom.type}"/></td>
<td><c:out value="${uom.model}"/></td>
<td><c:out value="${uom.dsc}"/></td>
<td><a href= "delete?id=${uom.id}">DELETE</a></td>
<td><a href= "edit?id=${uom.id}">UPDATE</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>
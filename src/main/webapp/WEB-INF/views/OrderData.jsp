<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2 style="color:red">Welcome To OrderMetod Data Page</h2>
<a href="excel">Excel Export</a>   |   <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>ORDERMODE</th>
<th>ORDERCODE</th>
<th>ORDERMETHOD</th>
<th>ORDERACCEPT</th>
<th>DESCRIPTION</th>
<th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="orderMethod">
<tr>
<td><c:out value="${orderMethod.id}"/></td>
<td><c:out value="${orderMethod.mode}"/></td>
<td><c:out value="${orderMethod.code}"/></td>
<td><c:out value="${orderMethod.method}"/></td>
<td><c:out value="${orderMethod.accept}"/></td>
<td><c:out value="${orderMethod.dsc}"/></td>
<td><a href= "delete?id=${orderMethod.id}">DELETE</a></td>
<td><a href= "edit?id=${orderMethod.id}">UPDATE</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>


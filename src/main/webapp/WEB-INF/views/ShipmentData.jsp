<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2 style="color:red">Welcome To ShipmentTypeData Page</h2>
<a href="excel">Excel Export</a>   |   <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>MODE</th>
<th>CODE</th>
<th>ENABLED</th>
<th>GRADE</th>
<th>DSC</th>
<th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="shipmentType">
<tr>
<td><c:out value="${shipmentType.id}"/></td>
<td><c:out value="${shipmentType.mode}"/></td>
<td><c:out value="${shipmentType.code}"/></td>
<td><c:out value="${shipmentType.enabled}"/></td>
<td><c:out value="${shipmentType.grade}"/></td>
<td><c:out value="${shipmentType.dsc}"/></td>
<td><a href= "delete?id=${shipmentType.id}">DELETE</a></td>
<td><a href= "edit?id=${shipmentType.id}">UPDATE</a></td>

</tr>
</c:forEach>
</table>
${message}
</body>
</html>


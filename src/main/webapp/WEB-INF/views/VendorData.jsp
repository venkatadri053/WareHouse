<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2 style="color:red">Welcome To Uom Data Page</h2>

<a href="excel">Excel Export</a>   |   <a href="pdf">PDF Export</a>

<table border="1">
<tr >
<th>VENDOR ID</th>
<th>VENDOR NAME</th>
<th>VENDOR CODE</th>
<th>VENDOR DESG.</th>
<th>VENDOR PRESERVE</th>
<th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="vendor">
<tr>
<td><c:out value="${vendor.venId}"/></td>
<td><c:out value="${vendor.venName}"/></td>
<td><c:out value="${vendor.venCode}"/></td>
<td><c:out value="${vendor.venDesg}"/></td>
<td><c:out value="${vendor.venPreserve}"/></td>
<td><a href= "delete?venId=${vendor.venId}">DELETE</a></td>
<td><a href= "edit?venId=${vendor.venId}">UPDATE</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>
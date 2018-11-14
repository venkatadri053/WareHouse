<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2 style="color:red">Welcome To PurchaseOrder Data Page</h2>

<table border="1">
<tr >
<th>PURCHASE ID</th>
<th>ORDER CODE</th>
<th>REFERENCE NUMBER</th>
<th>QUALITY CHECK</th>
<th>CUSTOMER LOCATIONS</th>


<th>DEFAULT STATUS</th>
<th>DESCRIPTION</th>
<th colspan="2">OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="purchase">
<tr>
<td><c:out value="${purchase.id}"/></td>
<td><c:out value="${purchase.orderCode}"/></td>
<td><c:out value="${purchase.referenceNumber}"/></td>
<td><c:out value="${purchase.qualityCheck}"/></td>
<td><c:out value="${purchase.defaultStatus}"/></td>
<td><c:out value="${purchase.dsc}"/></td>
<td><a href= "delete?id=${purchase.id}">DELETE</a></td>
<td><a href= "edit?id=${purchase.id}">UPDATE</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>
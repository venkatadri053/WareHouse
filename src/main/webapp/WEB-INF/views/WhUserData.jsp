<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2 style="color:red">Welcome To WhUserData Page</h2>
<a href="excel">Excel Export</a>   |   <a href="pdf">PDF Export</a>
<table border="1">
<tr>
<th>ID</th>
<th>TYPE</th>
<th>CODE</th>
<th>FORTYPE</th>
<th>EMAIL</th>
<th>CONTACT</th>
<th>IDTYPE</th>
<th>IFOTHER</th>
<th>IDNUM</th>
<th colspan="2">CRUD-OPERATIONS</th>
</tr>
<c:forEach items="${list}" var="whUserType">
<tr>
<td><c:out value="${whUserType.id}"/></td>
<td><c:out value="${whUserType.type}"/></td>
<td><c:out value="${whUserType.code}"/></td>
<td><c:out value="${whUserType.forType}"/></td>
<td><c:out value="${whUserType.email}"/></td>
<td><c:out value="${whUserType.contact}"/></td>
<td><c:out value="${whUserType.idType}"/></td>
<td><c:out value="${whUserType.ifOther}"/></td>
<td><c:out value="${whUserType.idNum}"/></td>
<td><a href= "delete?id=${whUserType.id}">DELETE</a></td>
<td><a href= "edit?id=${whUserType.id}">UPDATE</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>


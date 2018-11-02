<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<body>
<h2>Welcome toDocuments Page!!</h2>
<form  action="upload" method="post" enctype="multipart/form-data" >
<pre>
FILE:<input type="file" name="file"/>
<input type="submit" value="UPLOAD">
</pre>
</form>
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>LINK</th>
</tr>
<c:forEach items="${docs}" var="doc">
<tr>
	<td><c:out value="${doc[0]}"/></td>
	<td><c:out value="${doc[1]}"/></td>
	<td><a href="downloadDoc?docId=${doc[0]}">DOWNLOAD</a></td>
</tr>
</c:forEach>
</table>
${message}
</body>
</html>
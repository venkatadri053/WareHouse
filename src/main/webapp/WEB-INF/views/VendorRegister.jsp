<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2 style="color: red">Welcome To Vendor Register Page</h2>
<form:form action="insert" method="post" modelAttribute="vendor">
<pre>
VENDOR NAME:<form:input path="venName"/>
VENDOR CODE:<form:select path="venCode">
						<form:option value="">--SELECT--</form:option>
						<form:option value="CAT">CAT</form:option>
						<form:option value="RES">RES</form:option>
						</form:select>				
VEDOR DESIGNATION:  <form:radiobutton path="venDesg" value="SALE"/>SALE
											 <form:radiobutton path="venDesg" value="SERVICE"/>SERVICE
											  <form:radiobutton path="venDesg" value="BOTH"/>BOTH
VENDOR PRESERVE:<form:checkbox path="venPreserve" value="A"/>A
										<form:checkbox path="venPreserve" value="B"/>B
										<form:checkbox path="venPreserve" value="C"/>C
<input type="submit" value="CREATE VENDOR">
</pre>
</form:form>
${message}
</body>
</html>
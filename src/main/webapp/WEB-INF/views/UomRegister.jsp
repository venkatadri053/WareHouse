<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2 style="color: red">Welcome To UOM Register Page</h2>
<form:form action="insert" method="post" modelAttribute="uom">
<pre>
UOMTYPE:    <form:select path="type">
				<form:option value="">--SELECT--</form:option>
				<form:option value="PACK">PACKING</form:option>
				<form:option value="NOPACK">NOPACKING</form:option>
				<form:option value="-NA-">--NA--</form:option>
				</form:select>
				
UOMMODEL:   <form:input path="model" />

DESCRIPTION:<form:textarea path="dsc" />

<input type="submit" value="CREATE UOM">
</pre>
</form:form>
${message}
</body>
</html>
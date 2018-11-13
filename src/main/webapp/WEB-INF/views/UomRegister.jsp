<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<style type="text/css">
.errors {
	color: red;
}
</style>
<body>
	<h2 style="color: red">Welcome To UOM Register Page</h2>

	<form:form action="insert" method="post" modelAttribute="uom">
		<pre>
UOMTYPE    : <form:select path="type">
					<form:option value="">--SELECT--</form:option>
					<form:option value="PACKING">PACKING</form:option>
					<form:option value="NOPACKING">NOPACKING</form:option>
					<form:option value="--NA--">--NA--</form:option>
					</form:select>
<form:errors  path="type"  cssClass="errors" />			

UOMMODEL   : <form:input path="model" />
<form:errors path="model" cssClass="errors" />

DESCRIPTION:<form:textarea path="dsc" />
<form:errors path="dsc" cssClass="errors" />

<input type="submit" value="CREATE UOM">
</pre>
	</form:form>
	${message}
</body>
</html>
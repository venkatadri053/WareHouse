<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To UOM Page</h2>
<form:form action="update" method="POST" modelAttribute="uom">
<pre>
ID:<form:input path="id" readOnly="true"/>
UOMTYPE:<form:select path="type">
    <form:option value="">-SELECT-</form:option>
    <form:option value="PACK">PACKING</form:option>
    <form:option value="NOPACK">NO PACKING</form:option>
    <form:option value="">-NA-</form:option>
    </form:select>
UOMMODEL:<form:input path="model"/>
DESCRIPTION:<form:textarea path="dsc" />
<input type="SUBMIT" value="UPDATE"/>
</pre></form:form>
${message}
</body>
</html>

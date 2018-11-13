<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<style type="text/css">
.errors {
	color: red;
}
</style>
<body>
<h2  style="color:red ">Welcome To OrderMethod Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="orderMethod">
<pre>
Order Mode:<form:radiobutton path="mode" value="SALE"/>SALE  <form:radiobutton path="mode" value="PURCHASE"/>PURCHASE

Order Code:<form:input path="code"/>
<form:errors  path="code"  cssClass="errors" />

Order Method:<form:select path="method">
						    <form:option value="">-SELECT-</form:option>
    						<form:option value="FIFO">FIFO</form:option>
    						<form:option value="LIFO">LIFO</form:option>
    						<form:option value="FCFO">FCFO</form:option>
    						<form:option value="FEFO">FEFO</form:option>
    						</form:select>
<form:errors  path="method"  cssClass="errors" />

Order Accept:<form:checkbox path="accept" value="MULTIMODEL"/>MultiModel  <form:checkbox path="accept" value="ACCEPTRETURN"/>AcceptReturn
<form:errors  path="accept"  cssClass="errors" />

Description:<form:textarea path="dsc" />
<form:errors  path="dsc"  cssClass="errors" />

<input type="submit" value="CreateOrderMethod"/>
</pre></form:form>
${message}
</body>

</html>

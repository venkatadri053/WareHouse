<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To OrderMetod Page</h2>
<form:form action="update" method="POST" modelAttribute="orderMethod">
<pre>
ID:<form:input path="id" readOnly="true"/>

ORDER MODE: <form:radiobutton path="mode" value="SALE"/>SALE <form:radiobutton path="mode" value="PURCHASE"/>PURCHASE

ORDER CODE: <form:input path="code"/>

ORDER METHOD: <form:select path="method">
    							<form:option value="">-SELECT-</form:option>
    							<form:option value="FIFO">FIFO</form:option>
    							<form:option value="LIFO">LIFO</form:option>
    							<form:option value="FCFO">FCFO</form:option>
    							<form:option value="FEFO">FEFO</form:option>
    							</form:select>

ORDER ACCEPT:<form:checkbox path="accept" value="MULTIMODEL"/>MultiModel <form:checkbox path="accept" value="ACCEPTRETURN"/>AcceptReturn

DESCRIPTION: <form:textarea path="dsc" />

<input type="submit" value="UPDATE ORDER"/>
</pre></form:form>
${message}
</body>
</html>

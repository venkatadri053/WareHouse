<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<body>
<h2  style="color:red ">Welcome To OrderMethod Register Page</h2>
<form:form action="insert" method="POST" modelAttribute="orderMethod">
<pre>
Order Mode:<form:radiobutton path="mode" value="Male"/>Male
          <form:radiobutton path="mode" value="Female"/>Female
Order Code:<form:input path="code"/>
Order Method:<form:select path="method">
    <form:option value="">-SELECT-</form:option>
    <form:option value="FIFO">FIFO</form:option>
    <form:option value="LIFO">LIFO</form:option>
    <form:option value="FCFO">FCFO</form:option>
    <form:option value="FEFO">FEFO</form:option>
    </form:select>
Order Accept:
<form:checkbox path="accept" value="MULTIMODEL"/>MultiModel
<form:checkbox path="accept" value="ACCEPTRETURN"/>AcceptReturn
Description:<form:textarea path="dsc" />
<input type="submit" value="CreateOrderMethod"/>
</pre></form:form>
${message}
</body>

</html>
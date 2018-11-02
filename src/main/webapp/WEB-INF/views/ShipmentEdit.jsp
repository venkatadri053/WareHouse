<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To ShipmentType Page</h2>
<form:form action="update" method="POST" modelAttribute="shipmentType">
<pre>
ID:<form:input path="id" readOnly="true"/>
Shipment Mode:<form:select path="mode">
    <form:option value="">-SELECT-</form:option>
    <form:option value="AIR">Air</form:option>
    <form:option value="TRUCK">Truck</form:option>
    <form:option value="SHIP">Ship</form:option>
    <form:option value="TRAIN">Train</form:option>
    </form:select>
Shipment Code: <form:input path="code"/>
Enable Shipment:<form:checkbox path="enabled" value="YES"/>YES
Shipment Grade:<form:radiobutton path="grade" value="A"/>A<form:radiobutton path="grade" value="B"/>B<form:radiobutton path="grade" value="Female"/>c
Description:<form:textarea path="dsc" />
<input type="submit" value="update"/>
</pre></form:form>
${message}
</body>
</html>

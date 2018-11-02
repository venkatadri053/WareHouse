<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To UOM Page</h2>
<form:form action="update" method="POST" modelAttribute="customer">
<pre>
ID:<form:input path="custId" readOnly="true"/>
CUSTOMER CODE:<form:input path="custCode"/>
CUSTOMER ADDRESS:<form:textarea path="custAddr"/>
CUSTOMER LOCATION:<form:select path="custLocs">
											<form:option value="">--SELECT--</form:option>
											<form:option value="HYD">HYD</form:option>
											<form:option value="BAN">BAN</form:option>
											<form:option value="CHN">CHN</form:option>
											</form:select>
CUSTOMER ENABLED:<form:radiobutton path="custEnabled" value="YES"/>YES
											<form:radiobutton path="custEnabled" value="NO"/>NO
CUSTOMER EMAIL:<form:input path="custEmail"/>
CUSTOMER CONTACT:<form:input path="custContact"/>
<input type="SUBMIT" value="UPDATE"/>
</pre></form:form>
${message}
</body>
</html>

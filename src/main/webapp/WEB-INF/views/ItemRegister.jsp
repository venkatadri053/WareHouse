<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
<h2  style="color: red">Welcome To Item Register Page!!</h2>
<form:form action="insert" method="post" modelAttribute="item">
<pre>

ITEM CODE:<form:input path="code"/>

ITEM DIMENSIONS: W <form:input path="width" size="2" /> L<form:input path="length" size="2"/> H <form:input path="height" size="2"/>

BASE COST:<form:input path="cost"/>

BASE CURRENCY:<form:select path="currency">
								  <form:option value="">--SELECT--</form:option>
								  <form:option value="INR">INR</form:option>
								  <form:option value="USD">USD</form:option>
								  <form:option value="AUS">AUS</form:option>
								  <form:option value="ERU">ERU</form:option>
								  </form:select>
								 
ITEM UOM: <form:select path="uom.id">
					  <form:option value="">--SELECT--</form:option>
					  <form:options items="${uoms}" itemLabel="model" itemValue="id"/>
					  </form:select>
					  
ORDERMETHOD:(SaleType)<form:select path="saleType.id">
													<form:option value="">--SELECT--</form:option>
													<form:options items="${sales}" itemLabel="code" itemValue="id"/>
													</form:select>				  
			 
ORDERMETHOD:(PurchaseType)<form:select path="purchaseType.id">
																<form:option value="">--SELECT--</form:option>
																<form:options items="${purchase}" itemLabel="code" itemValue="id"/>
																</form:select>

ITEM VENDORS:<form:select path="venUsers" >
							<form:option value="">-SELECT-</form:option>
							<form:options items="${vendors}" itemLabel="userCode" itemValue="id"/>
							</form:select>

ITEM CUSTOMERS:<form:select path="custUsers">
 								<form:option value="">-SELECT-</form:option>
								<form:options items="${customers}" itemLabel="userCode" itemValue="id"/>
								</form:select>
																			  		
DESCRPTION:<form:textarea path="dsc"/>


<input type="submit" value="CREATE ITEM">
</pre></form:form>
${message}
</body>
</html>
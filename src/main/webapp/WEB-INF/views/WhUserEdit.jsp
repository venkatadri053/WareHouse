<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To WhUser Page</h2>
<form:form action="update" method="POST" modelAttribute="whUserType">
<pre>
ID:<form:input path="id" readOnly="true"/>

User Type:<form:radiobutton path="userType" value="Vendor"/>Vendor  <form:radiobutton path="userType" value="Customer"/>Customer

User code:<form:input path="userCode"/>

User For:<form:input path="userFor"/>

User Email:<form:input path="userEmail"/>

User Contact:<form:input path="userContact"/>

User ID Type:<form:select path="userIdType">
    					<form:option value="">-SELECT-</form:option>
    					<form:option value="PANCARD">PAN CARD</form:option>
    					<form:option value="AADHAR">AADHAR</form:option>
    					<form:option value="VOTERID">VOTERID</form:option>
   						 <form:option value="OTHER">OTHER</form:option>
    					</form:select>
    
*If Other:<form:input path="ifOther"/>

ID Number:<form:input path="idNum"/>

<input type="submit" value="update"/>
</pre></form:form>
${message}
</body>
</html>

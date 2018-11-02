<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<h2  style="color:red ">Welcome To WhUser Page</h2>
<form:form action="update" method="POST" modelAttribute="whUserType">
<pre>
ID:<form:input path="id" readOnly="true"/>
User Type:<form:radiobutton path="type" value="Vendor"/>Vendor <form:radiobutton path="type" value="Customer"/>Customer        
User code:<form:input path="code"/>
User For:<form:input path="forType"/>
User Email:<form:input path="email"/>
User Contact:<form:input path="contact"/>
User ID Type:<form:select path="idType">
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

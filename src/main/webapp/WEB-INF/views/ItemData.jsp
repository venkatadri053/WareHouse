<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h2 style="color: red">Welcome To ItemDataPage!!</h2>

	<table border="1">
		<tr>
			<th>ITEM ID</th>
			<th>ITEM CODE</th>
			<th>ITEM DIMENSIONS</th>
			<th>BASE COST</th>
			<th>BASE CURRENCY</th>
			<th>UOM</th>
			<th>SALE</th>
			<th>PURCHASE</th>
			<th>VENDOR</th>
			<th>USERTYPE</th>
			<th>NOTE</th>
			<th>DESCRIPTION</th>
			<th colspan="2">OPERATIONS</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td><c:out value="${item.id}" /></td>
				<td><c:out value="${item.code}" /></td>
				<td>Width:<c:out value="${item.width}" />, Length:<c:out
						value="${item.length}" />, Height:<c:out value="${item.height}" /></td>
				<td><c:out value="${item.cost}" /></td>
				<td><c:out value="${item.currency}" /></td>

				<td><c:out value="${item.uom.model}" /></td>

				<td>SALE:<c:out value="${item.saleType.code}" /></td>

				<td>PURCHASE:<c:out value="${item.purchaseType.code}" /></td>


				<td><c:forEach items="${itm.venUsers}" var="ven">
						<c:out value="${ven.userCode}" />,
						</c:forEach>
				</td>
				
				<td><c:forEach items="${itm.custUsers}" var="cust">
						<c:out value="${cust.userCode}" />,
						</c:forEach>
				</td>

				<td><c:out value="${item.dsc}" /></td>


				<td><a href="delete?id=${item.id}">DELETE</a></td>
				<td><a href="edit?id=${item.id}">EDIT</a></td>
			</tr>


		</c:forEach>
	</table>
	${message}
</body>
</html>
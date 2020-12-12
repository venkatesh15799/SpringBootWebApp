<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
		function confirmDelete(){
				return confirm("Are you sure, You want to delete?");
		}
</script>
</head>
<body>
<a href="loadForm">Add New Contacts</a>
<h4> View All Contacts</h4>
	<table class="text-center text-white" style="background-color: rgb(134, 226, 230);">
		<thead>
			<tr>
				<th>ContactName</th>
				<th>ContactNumber</th>
				<th>ContacEmail</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c">
			<tr>
				<td>${c.contactName}</td>
				<td>${c.contactNumber}</td>
				<td>${c.contactEmail}</td>
				<td><a href="editContact?cid=${c.contactId}">Edit</a>&nbsp;
				<a href="deleteContact?cid=${c.contactId}" onclick="return confirmDelete()">delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
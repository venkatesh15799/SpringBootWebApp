<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4> Save Contact</h4>

		${succMsg}  ${errMsg}
		${msg}

<form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
	<table  style="background-color: rgba(20, 208, 221, 0.658); font-size: 20px;">
		<tr>
				<td>Contact Name</td>
				<td><form:input path="contactName"/></td>
		</tr>
		<tr>	
				<td>Contact Number</td>
				<td><form:input path="contactNumber"/></td>
		</tr>
		<tr>		
				<td>Contact Email</td>
				<td><form:input path="contactEmail"/></td>
		</tr>
		<tr>	
				<td colspan="1"></td>
				<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>
	<a href="viewContacts">View All Contacts</a>
</form:form>
</body>
</html>
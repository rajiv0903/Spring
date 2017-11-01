<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="page.title" /></title>

<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<div>
		<table>
			<thead>
				<tr>
					<th><spring:message code="register.success" /></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><spring:message code="register.name" /> :${customer.name}</td>
				</tr>
				<tr>
					<td><spring:message code="register.state" />
						:${customer.address.state}</td>
				</tr>
				<tr>
					<td><spring:message code="register.dob" />
						:<fmt:formatDate value="${customer.dateOfBirth}" pattern="MM/dd/yyyy" /></td>
				</tr>
				<tr>
					<td><spring:message code="register.gender" />
						:${customer.gender}</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>
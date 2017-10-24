<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Goal Reports</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Minutes</th>
			<th>Exercise Minutes</th>
			<th>Activity</th>
		</tr>
		<c:if test="${not empty goalReports}">
			<c:forEach items="${goalReports}" var="goal">
				<tr>
					<td>${goal.goalMinutes }</td>
					<td>${goal.exerciseMinutes }</td>
					<td>${goal.exerciseActivity }</td>
				</tr>
			</c:forEach>
		</c:if>

	</table>
</body>
</html>
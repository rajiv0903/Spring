<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="page.title" /></title>

<script type="text/javascript">
	function loadStates() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var data = JSON.parse(this.responseText);
				var len = data.length;
				var html = '<option value="">--Please select one--</option>';
				for (var i = 0; i < len; i++) {
					html += '<option value="'+ data[i].state + '">'
							+ data[i].state + '</option>';
				}
				html += '</option>';
				document.getElementById('states').innerHTML = html;
			}
		};
		xhttp.open("GET", '<spring:url value="states.json"/>', true);
		xhttp.send();
	}
</script>

<link href="css/style.css" rel="stylesheet" type="text/css">

</head>
<body onload="loadStates();">

	<span style="float: right"> <a href="?language=en"><spring:message
				code="register.eng" /> | <a href="?language=sp"><spring:message
					code="register.sp" /></a></span>


	<form:form commandName="customer">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><spring:message code="register.name" /> :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="register.passwd" /> :</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="register.confirmpass" /> :</td>
				<td><form:password path="confirmpassword" /></td>
				<td><form:errors path="confirmpassword" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="register.address" /> :</td>
				<td><form:textarea path="address.address" /></td>
				<td><form:errors path="address.address" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="register.state" /> :</td>
				<td>
					<!-- Add code here to fetch and display State dropdown values from controller -->
					<form:select id="states" path="address.state"></form:select>
				<td><form:errors path="address.state" cssClass="error" /></td>


			</tr>
			<tr>
				<td><spring:message code="register.dob" /> :</td>
				<td><form:input type="date" path="dateOfBirth" /></td>
				<td><form:errors path="dateOfBirth" cssClass="error" /></td>
			</tr>

			<tr>
				<td><spring:message code="register.gender" /></td>
				<td>
					<!-- Add code for radio button here --> 
					<form:radiobutton path="gender" value="male" /> <spring:message
						code="register.male" /> 
					<form:radiobutton path="gender" value="female" /> <spring:message
						code="register.female" />
					<td><form:errors path="gender" cssClass="error" /></td>
				</td>
				
			</tr>

			<tr>
				<td>
					<!-- Add code to display checkbox for declaration --> <form:checkbox
						path="isAgreed" />
				</td>
				<td><spring:message code="register.isAgreed" /></td>
				<td><form:errors path="isAgreed" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>

		</table>
	</form:form>

</body>
</body>
</html>
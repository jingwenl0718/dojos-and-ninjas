<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja Form</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/add" method="POST" modelAttribute="newNinja">
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<form:errors style="color:red" path="firstName" />
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<form:errors style="color:red" path="lastName" />
		</p>
		<p>
			<form:label path="age">Age:</form:label>
			<form:input path="age" />
			<form:errors style="color:red" path="age" />
		</p>
		<form:hidden path="dojo" />
		<button type="submit">Create</button>
	</form:form>
</body>
</html>
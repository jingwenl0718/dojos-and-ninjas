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
	<title>New Dojo Form</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new" method="POST" modelAttribute="newDojo">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name" />
			<form:errors style="color:red" path="name" />
		</p>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>
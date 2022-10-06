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
	<title>Insert title here</title>
</head>
<body>
	<h1>All Dojos</h1>
	<ul>
		<c:forEach var="eachDojo" items="${dojoList}">
			<li><a href="/dojos/${eachDojo.id }"><c:out value="${eachDojo.name}"/></a></li>
		</c:forEach>
	</ul>
	<a href="/dojos/new">Add a new dojo</a>
</body>
</html>
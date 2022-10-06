<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Dojo Details</title>
</head>
<body>
	<h1><c:out value="${dojo.name }"/> Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="eachNinja" items="${dojo.ninjas }">
				<tr>
					<td><c:out value="${eachNinja.firstName }"/></td>
					<td><c:out value="${eachNinja.lastName }"/></td>
					<td><c:out value="${eachNinja.age }"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/ninjas/add">Add a Ninja</a><br/>
	<a href="/">Back to Dashboard</a>
</body>
</html>
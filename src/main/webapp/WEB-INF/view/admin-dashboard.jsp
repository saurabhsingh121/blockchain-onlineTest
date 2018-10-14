<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>

<head>
	<title>Transactions</title>

	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Admin Dashboard</h2>
		</div>
	</div>
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->

			<input type="button" value="Add Question"
				   onclick="window.location.href='showFormForAddingQuestion'; return false;"
				   class="add-button"
			/>

			<input type="button" value="Add User"
				   onclick="window.location.href='showFormForAddingTransfer'; return false;"
				   class="add-button"
			/>
			<!--  add our html table here -->

			<table>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Test Id</th>
					<th>Score</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${theUsers}">

					<tr>
						<td> ${tempUser.userId} </td>
						<td> ${tempUser.userName} </td>
						<td> ${tempUser.testId} </td>
						<td> ${tempUser.score} </td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	<hr>
	
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>

</html>

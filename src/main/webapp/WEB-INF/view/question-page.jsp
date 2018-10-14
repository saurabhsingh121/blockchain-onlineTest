<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html>

<head>
<title>Process Request</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Process Request</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
			<p>
				User:
				<security:authentication property="principal.username" />
				, Role(s):
				<security:authentication property="principal.authorities" />
			</p>
			<input type="button" value="Get Score"
				   onclick="window.location.href='getScore'; return false;"
				   class="add-button"
			/>
			<!--  add our html table here -->
			<form:form action="calculateScore" method="POST">
				<table>
					<tr>
						<th>Question No:</th>
						<td>${question.questionNo}</td>
						<td><input type="hidden" name="questNo"
							value="${question.questionNo}"></td>
					</tr>
					<tr>
						<th>Question:</th>
						<td>${question.question}</td>
					</tr>
					<tr>
						<th>Options:</th>
					</tr>
					<tr>
						<td><input type="radio" name="correctOption" value="1" /></td>
						<td>${question.option1}</td>
					</tr>
					<tr>
						<td><input type="radio" name="correctOption" value="2" /></td>
						<td>${question.option2}</td>
					</tr>
					<tr>
						<td><input type="radio" name="correctOption" value="3" /></td>
						<td>${question.option3}</td>
					</tr>
					<tr>
						<td><input type="radio" name="correctOption" value="4" /></td>
						<td>${question.option4}</td>
					</tr>
					<tr>
						<td><input type="submit" value="Next" class="save" /></td>
					</tr>
				</table>
			</form:form>
		</div>

	</div>

	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" class="add-button" />

	</form:form>

</body>

</html>

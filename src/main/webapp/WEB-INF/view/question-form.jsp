<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>

<head>
<title>Add New Question</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add New Question</h2>
		</div>
	</div>

	<p>
		User:
		<security:authentication property="principal.username" />
		<br>
		<br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>

	<div id="container">
		<h3>New Question Detail</h3>

		<form:form action="addQuestion" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>Question No:</label></td>
						<td><input type="number" name="questionNo"></td>
					</tr>

					<tr>
						<td><label>Question:</label></td>
						<td><input type="text" name="question" /></td>
					</tr>

					<tr>
						<td><label>Correct Option:</label></td>
						<td><input type="number" name="correctOption" /></td>
					</tr>

					<tr>
						<td><label>Option 1:</label></td>
						<td><input type="text" name="option1" /></td>
					</tr>

					<tr>
						<td><label>Option 2:</label></td>
						<td><input type="text" name="option2" /></td>
					</tr>

					<tr>
						<td><label>Option 3:</label></td>
						<td><input type="text" name="option3" /></td>
					</tr>

					<tr>
						<td><label>Option 4:</label></td>
						<td><input type="text" name="option4" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Send" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/transaction/list">Back
				to List</a>
		</p>

	</div>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add New User</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add New User</h2>
		</div>
	</div>
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	<div id="container">
		<h3>User Detail</h3>

		<form:form action="addUser" modelAttribute="user" method="POST">

			<table>
				<tbody>
					<tr>
						<td><label>User Id:</label></td>
						<td><form:input path="userId" /></td>
					</tr>

					<tr>
						<td><label>User Name:</label></td>
						<td><form:input path="userName" /></td>
					</tr>

					<tr>
						<td><label>Test Id:</label></td>
						<td><form:input path="testId" /></td>
					</tr>

					<tr>
						<td><label>Score Id:</label></td>
						<td><form:input path="score" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/admin/getUserList">Back to List</a>
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
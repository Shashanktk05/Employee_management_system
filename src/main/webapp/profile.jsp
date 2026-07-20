<%@page import="entityLayer.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Employee employee = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	background: #f4f6f9;
}

.navbar {
	background: #2c3e50;
	padding: 15px 40px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	color: white;
}

.navbar h2 {
	font-size: 24px;
}

.navbar a {
	text-decoration: none;
	color: white;
	background: #3498db;
	padding: 10px 18px;
	border-radius: 5px;
}

.navbar a:hover {
	background: #2980b9;
}

.container {
	width: 700px;
	margin: 40px auto;
	background: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, .2);
}

.container h2 {
	text-align: center;
	margin-bottom: 30px;
	color: #2c3e50;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table tr {
	border-bottom: 1px solid #ddd;
}

table td {
	padding: 15px;
	font-size: 17px;
}

.label {
	font-weight: bold;
	width: 200px;
	color: #34495e;
}

.value {
	color: #555;
}
</style>

</head>
<body>

	<div class="navbar">

		<h2>Employee Dashboard</h2>

		<a href="employeeDashboard.jsp">Dashboard</a>

	</div>

	<div class="container">

		<h2>My Profile</h2>

		<table>

			<tr>
				<td class="label">Employee ID</td>
				<td class="value"><%=employee.getId()%></td>
			</tr>

			<tr>
				<td class="label">Full Name</td>
				<td class="value"><%=employee.getName()%></td>
			</tr>

			<tr>
				<td class="label">Email</td>
				<td class="value"><%=employee.getEmail()%></td>
			</tr>

			<tr>
				<td class="label">Phone</td>
				<td class="value"><%=employee.getPhoneNumber()%></td>
			</tr>

			<tr>
				<td class="label">Address</td>
				<td class="value"><%=employee.getAddress()%></td>
			</tr>

			<tr>
				<td class="label">Salary</td>
				<td class="value">₹ <%=employee.getSalary()%></td>
			</tr>

			<tr>
				<td class="label">Status</td>
				<td class="value"><%=employee.isActive() ? "Active" : "Inactive"%>
				</td>
			</tr>

		</table>

	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="entityLayer.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background: linear-gradient(135deg, #43cea2, #185a9d);
	min-height: 100vh;
	padding: 30px;
}

.container {
	width: 95%;
	margin: auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, .25);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #2c3e50;
}

table {
	width: 100%;
	border-collapse: collapse;
	text-align: center;
}

th {
	background: #3498db;
	color: white;
	padding: 12px;
}

td {
	padding: 10px;
	border: 1px solid #ddd;
}

tr:nth-child(even) {
	background: #f2f2f2;
}

.button {
	margin-top: 20px;
	text-align: center;
}

.button a {
	text-decoration: none;
	background: #27ae60;
	color: white;
	padding: 10px 20px;
	border-radius: 6px;
	font-weight: bold;
}

.button a:hover {
	background: #1e8449;
}

.flexbtn {
	display: flex;
	justify-content: center;
	gap: 25px;
}
</style>

</head>
<body>

	<div class="container">

		<h2>Employee Details</h2>

		<table>

			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Address</th>
				<th>Salary</th>
				<th>Status</th>
			</tr>

			<%
			if ("single".equals(request.getAttribute("type"))) {

				Employee e = (Employee) request.getAttribute("employee");

				if (e == null) {
			%>

			<tr>
				<td colspan="8">No Employee Found.</td>
			</tr>

			<%
			} else {
			%>

			<tr>
				<td><%=e.getId()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getAge()%></td>
				<td><%=e.getEmail()%></td>
				<td><%=e.getPhoneNumber()%></td>
				<td><%=e.getAddress()%></td>
				<td><%=e.getSalary()%></td>
				<td><%=e.isActive() ? "Active" : "Inactive"%></td>
			</tr>

			<%
			}

			} else {

			List<Employee> list = (List<Employee>) request.getAttribute("list");

			if (list != null && !list.isEmpty()) {

			for (Employee e : list) {
			%>

			<tr>
				<td><%=e.getId()%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getAge()%></td>
				<td><%=e.getEmail()%></td>
				<td><%=e.getPhoneNumber()%></td>
				<td><%=e.getAddress()%></td>
				<td><%=e.getSalary()%></td>
				<td><%=e.isActive() ? "Active" : "Inactive"%></td>
			</tr>

			<%
			}

			} else {
			%>

			<tr>
				<td colspan="8">No Employees Found.</td>
			</tr>

			<%
			}
			}
			%>

		</table>

		<div class="flexbtn">
			<div class="button">

				<a href="select.html"> Go back </a>

			</div>

			<div class="button">

				<a href="index.html"> Go Home </a>

			</div>

		</div>



	</div>

</body>
</html>

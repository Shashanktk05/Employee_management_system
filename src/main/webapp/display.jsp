<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="entityLayer.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<style>
	body {
		padding: var(--spacing-32) var(--spacing-20);
		align-items: flex-start;
	}
	.notion-card-wide {
		margin: 0 auto;
	}
</style>
</head>
<body>

	<div class="notion-card notion-card-wide">
		<div class="page-icon">👥</div>
		<h2 style="text-align: center; margin-bottom: var(--spacing-4);">Employee Registry</h2>
		<p class="editorial-intro" style="text-align: center; margin-bottom: var(--spacing-32);">
			View active and inactive employee directory details from the database.
		</p>

		<div class="notion-table-container">
			<table class="notion-table">
				<thead>
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
				</thead>
				<tbody>
					<%
					if ("single".equals(request.getAttribute("type"))) {
		
						Employee e = (Employee) request.getAttribute("employee");
		
						if (e == null) {
					%>
		
					<tr>
						<td colspan="8" class="empty-state">
							<div class="empty-state-icon">📂</div>
							<p>No Employee Found.</p>
						</td>
					</tr>
		
					<%
					} else {
					%>
		
					<tr>
						<td style="font-weight: 600;"><%=e.getId()%></td>
						<td style="font-weight: 500; color: var(--color-ink-black);"><%=e.getName()%></td>
						<td><%=e.getAge()%></td>
						<td><%=e.getEmail()%></td>
						<td><%=e.getPhoneNumber()%></td>
						<td><%=e.getAddress()%></td>
						<td style="font-family: monospace; font-size: 13px;"><%=e.getSalary()%></td>
						<td>
							<% if (e.isActive()) { %>
								<span class="pill pill-active">Active</span>
							<% } else { %>
								<span class="pill pill-inactive">Inactive</span>
							<% } %>
						</td>
					</tr>
		
					<%
					}
		
					} else {
		
					List<Employee> list = (List<Employee>) request.getAttribute("list");
		
					if (list != null && !list.isEmpty()) {
		
					for (Employee e : list) {
					%>
		
					<tr>
						<td style="font-weight: 600;"><%=e.getId()%></td>
						<td style="font-weight: 500; color: var(--color-ink-black);"><%=e.getName()%></td>
						<td><%=e.getAge()%></td>
						<td><%=e.getEmail()%></td>
						<td><%=e.getPhoneNumber()%></td>
						<td><%=e.getAddress()%></td>
						<td style="font-family: monospace; font-size: 13px;"><%=e.getSalary()%></td>
						<td>
							<% if (e.isActive()) { %>
								<span class="pill pill-active">Active</span>
							<% } else { %>
								<span class="pill pill-inactive">Inactive</span>
							<% } %>
						</td>
					</tr>
		
					<%
					}
		
					} else {
					%>
		
					<tr>
						<td colspan="8" class="empty-state">
							<div class="empty-state-icon">📂</div>
							<p>No Employees Found.</p>
						</td>
					</tr>
		
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>

		<div class="button-group" style="justify-content: center; max-width: 320px; margin: var(--spacing-28) auto 0 auto;">
			<a href="select.html" class="btn-outline" style="text-decoration: none; text-align: center;">Go Back</a>
			<a href="index.html" class="btn-primary" style="text-decoration: none; text-align: center;">Go Home</a>
		</div>

	</div>

</body>
</html>

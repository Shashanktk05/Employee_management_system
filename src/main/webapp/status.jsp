<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<style>
	.status-badge {
		font-size: 32px;
		width: 64px;
		height: 64px;
		border-radius: 50%;
		display: flex;
		align-items: center;
		justify-content: center;
		margin: 0 auto var(--spacing-20) auto;
		user-select: none;
	}
	.status-success {
		background-color: #e2f5e9;
		color: #13783e;
	}
	.status-error {
		background-color: #fdebeb;
		color: #c93b3b;
	}
</style>
</head>
<body>
	<div class="notion-card" style="max-width: 420px; text-align: center;">

		<%
		if (request.getAttribute("status") != null && (boolean) request.getAttribute("status")) {
		%>
		<div class="status-badge status-success">✔</div>
		<h2><%=(String) request.getAttribute("key")%></h2>
		<p class="editorial-intro" style="margin-bottom: var(--spacing-28);"><%=(String) request.getAttribute("message")%></p>
		
		<div class="button-group">
			<a href="<%=(String) request.getAttribute("page")%>" class="btn-primary" style="text-decoration: none; text-align: center;">
				<%=(String) request.getAttribute("button")%>
			</a> 
			<a href="index.html" class="btn-outline" style="text-decoration: none; text-align: center;">Home</a>
		</div>
		<%
		} else {
		%>
		<div class="status-badge status-error">✖</div>
		<h2><%=(String) request.getAttribute("key")%></h2>
		<p class="editorial-intro" style="margin-bottom: var(--spacing-28);"><%=(String) request.getAttribute("message")%></p>
		
		<div class="button-group">
			<a href="<%=(String) request.getAttribute("page")%>" class="btn-danger" style="text-decoration: none; text-align: center;">
				<%=(String) request.getAttribute("button")%>
			</a> 
			<a href="index.html" class="btn-outline" style="text-decoration: none; text-align: center;">Home</a>
		</div>
		<%
		}
		%>

	</div>
</body>
</html>
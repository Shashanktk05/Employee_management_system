<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(135deg, #4facfe, #00f2fe);
}

.container {
	width: 420px;
	background: white;
	padding: 35px;
	text-align: center;
	border-radius: 12px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.25);
}

.icon {
	font-size: 70px;
	color: #27ae60;
}

h2 {
	margin: 15px 0;
	color: #2c3e50;
}

p {
	color: #555;
	margin-bottom: 25px;
}

.btn-group {
	display: flex;
	gap: 15px;
}

.btn {
	flex: 1;
	padding: 12px;
	text-decoration: none;
	color: white;
	font-weight: bold;
	border-radius: 6px;
	transition: .3s;
}

.insert {
	background: #27ae60;
}

.insert:hover {
	background: #1e8449;
}

.home {
	background: #3498db;
}

.home:hover {
	background: #2980b9;
}
</style>
</head>
<body>
	<div class="container">

		<%
		if ((boolean) request.getAttribute("status")) {
		%>
		<div class="icon">✔</div>
		<h2><%=(String) request.getAttribute("key")%>
		</h2>
		<p><%=(String) request.getAttribute("message")%></p>
		<div class="btn-group">
			<a href="<%=(String) request.getAttribute("page")%>"
				class="btn insert"><%=(String) request.getAttribute("button")%>
			</a> <a href="index.html" class="btn home"> Home </a>
		</div>
		<%
		} else {
		%>


		<div class="icon" style="color: #e74c3c;">✖</div>

		<h2><%=(String) request.getAttribute("key")%>
		</h2>
		<p><%=(String) request.getAttribute("message")%></p>
		<div class="btn-group">
			<a href="<%=(String) request.getAttribute("page")%>"
				class="btn insert"><%=(String) request.getAttribute("button")%>
			</a> <a href="index.html" class="btn home"> Home </a>
		</div>
		<%
		}
		%>

	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Employee Management System</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background: #f4f6f9;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	width: 380px;
	background: white;
	padding: 35px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, .2);
}

.container h2 {
	text-align: center;
	color: #2c3e50;
	margin-bottom: 25px;
}

.input-group {
	margin-bottom: 18px;
}

.input-group label {
	display: block;
	margin-bottom: 6px;
	font-weight: bold;
}

.input-group input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 15px;
}

button {
	width: 100%;
	padding: 12px;
	background: #007BFF;
	color: white;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

button:hover {
	background: #0056b3;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 15px;
}

.footer {
	margin-top: 20px;
	text-align: center;
	color: gray;
	font-size: 14px;
}
</style>

</head>
<body>

	<div class="container">

		<h2>Login</h2>

		<%
		if (request.getAttribute("error") != null) {
		%>
		<div class="error">
			<%=request.getAttribute("error")%>
		</div>
		<%
		}
		%>

		<form action="login" method="post">

			<div class="input-group">
				<label>Email</label> <input type="email" name="email"
					placeholder="Enter your email" required>
			</div>

			<div class="input-group">
				<label>Password</label> <input type="password" name="password"
					placeholder="Enter your password" required>
			</div>

			<button type="submit">Login</button>

		</form>

		<div class="footer">Employee Management System</div>

	</div>

</body>
</html>
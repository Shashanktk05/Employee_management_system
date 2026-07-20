<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Denied</title>

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
	width: 450px;
	background: #fff;
	padding: 40px;
	text-align: center;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
}

h1 {
	color: #dc3545;
	font-size: 32px;
	margin-bottom: 15px;
}

p {
	color: #555;
	font-size: 17px;
	margin-bottom: 30px;
}

a {
	text-decoration: none;
	background: #007bff;
	color: white;
	padding: 12px 25px;
	border-radius: 5px;
	font-size: 16px;
	transition: 0.3s;
}

a:hover {
	background: #0056b3;
}
</style>

</head>
<body>

	<div class="container">
		<h1>403 - Access Denied</h1>

		<p>
			You are not authorized to access this page. <br>
			<br> Please contact the administrator if you believe this is an
			error.
		</p>

		<a href="login.jsp">Back to Login</a>
	</div>

</body>
</html>
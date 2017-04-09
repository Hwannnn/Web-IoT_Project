<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="<%=request.getContextPath()%>/js/index.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/loginForm.css">
		<link rel="icon" type="image/png" sizes="16x16" href="./images/favicon-16x16.png">

    </head>

	<body>
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>		
				<form class="form" action="<%=request.getContextPath()%>/auth/login.do" method="post">
					<input type="text" name="auth_id" placeholder="Username">
					<input type="password" name="password" placeholder="Password">
					<button type="submit" id="login-button">Login</button><br/>
					<button type="button" id="login-button" onclick="location.href='./searchauth.do'">Search</button>
				</form>
			</div>
			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
    </body>
</html>

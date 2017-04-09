<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>LoginFail</title>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="<%=request.getContextPath()%>/js/index.js"></script>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/loginForm.css">
        <meta http-equiv="Refresh" content="1;url=login.do">
    </head>

	<body>
		<div class="wrapper">
			<div class="container">
				<h1>Login Failed</h1><br><br>
				<h2>로그인 실패입니다.<br><br>
				이메일 또는 암호가 맞지 않습니다.!<br><br>
				다시 로그인 화면으로 갑니다.</h2> 
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

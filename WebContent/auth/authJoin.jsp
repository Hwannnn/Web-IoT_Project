<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Auth Join</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
	</head>
	<body onload="tab_load(3)">
	
		<jsp:include page="../header.jsp"/>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<!-- Three -->
							<section id="three">
								<div class="container">
									<h3>Auth Register</h3>
									<p>신청자의 정보내역을 정확히 입력해주세요.</p><hr/>
									<form method="post" action="./join.do" name="form" id="form">
										<div class="row uniform">
											<div class="6u 12u(xsmall)">이름</div>
											<div class="6u 12u(xsmall)"><input type="text" name="name" id="name" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">주민등록번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="resident_num" id="resident_num" placeholder="주민등록번호    ex)000000-0000000" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">아이디</div>
											<div class="6u 12u(xsmall)"><input type="email" name="auth_id" id="auth_id" placeholder="신청자의 이메일이 아이디가됩니다." required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">비밀번호</div>
											<div class="6u 12u(xsmall)"><input type="password" name="password" id="password" placeholder="6~16자 영문대소문자, 숫자, 특수문자 혼합" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">전화번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="phone" id="phone" placeholder="전화번호    ex)010-0000-0000" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">이메일</div>
											<div class="6u 12u(xsmall)"><input type="email" name="email" id="email" required/></div>
										</div>
										<hr/>
										<div class="row uniform">
											<div class="12u" id="align-center">
												<ul class="actions">
													<li><input type="submit" class="special" value="Send" /></li>
													<li><input type="reset" value="Cancel" onClick="history.back()" /></li>
												</ul>
											</div>
										</div>
									</form>
								</div>
							</section>
					</div>
			</div>
	</body>
</html>
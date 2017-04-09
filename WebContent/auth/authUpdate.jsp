<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Auth Update</title>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
		<script src="<%=request.getContextPath()%>/js/index.js"></script>
	</head>
	<body onload="tab_load(1)">
	
		<jsp:include page="../header.jsp"/>

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Main -->
					<div id="main">
						<!-- Three -->
							<section id="three">
								<div class="container">
									<h3>Auth Update</h3>
									<p>신청자의 정보내역을 정확히 입력해주세요.</p><hr/>
									
									<form method="post" action="./authupdate.do" name="form" id="form">
										<div class="row uniform">
											<div class="6u 12u(xsmall)">회원번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="auth_no" id="auth_no" value = "${auth.auth_no}" required readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">아이디</div>
											<div class="6u 12u(xsmall)"><input type="email" name="auth_id" id="auth_id" value = "${auth.auth_id}" required readonly/></div>
											
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">*비밀번호</div>
											<div class="6u 12u(xsmall)"><input type="password" name="password" id="password" placeholder="기존의 비밀번호" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">*새 비밀번호</div>
											<div class="6u 12u(xsmall)"><input type="password" name="new_password" id="new_password" placeholder="변경할 비밀번호" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">이름</div>
											<div class="6u 12u(xsmall)"><input type="text" name="name" id="name" value = "${auth.name}" required readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">주민등록번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="resident_num" id="resident_num" value = "${auth.resident_num}" required readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">*전화번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="phone" id="phone" value = "${auth.phone}" placeholder="변경할 전화번호.. ex)010-0000-0000" required/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">*이메일</div>
											<div class="6u 12u(xsmall)"><input type="email" name="email" id="email" value = "${auth.email}" placeholder="변경할 이메일..." required/></div>
										</div>
										<hr/>
										<div class="row uniform">
											<div class="12u" id="align-center">
												<ul class="actions">
													<li><input type="submit" class="special" value="Send" /></li>
													<li><input type="reset" value="Cancel" onClick="history.back()"/></li>
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
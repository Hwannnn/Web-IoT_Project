<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Auth Info</title>
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
									<h3>Auth Info</h3><hr/>
									<form>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">No.</div>	
											<div class="6u 12u(xsmall)"><input type="text" name="auth_no" id="auth_no" value="${auth.auth_no}" required readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">아이디</div>
											<div class="6u 12u(xsmall)"><input type="email" name="auth_id" id="auth_id" value="${auth.auth_id}" required readonly/></div>
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
											<div class="6u 12u(xsmall)">이메일</div>
											<div class="6u 12u(xsmall)"><input type="email" name="email" id="email" value = "${auth.email}" required readonly/></div>
										</div>
										<div class="row uniform">
											<div class="6u 12u(xsmall)">전화번호</div>
											<div class="6u 12u(xsmall)"><input type="text" name="phone" id="phone" value = "${auth.phone}" required readonly/></div>
										</div>
										<hr/>
										<div class="row uniform">
											<div class="12u" id="align-center">
												<ul class="actions">
													<li><input type="button" value="Update" class="special" onclick='location.href="authupdate.do?auth_no=${auth.auth_no}";'/></li>
													<li><input type="button" value="Cancel" onclick='location.href="../index.jsp";'/></li>
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